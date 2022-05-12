package api;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DemoQATestAPI {

    private static final String DEMO_QA_BOOKS_URL = "https://demoqa.com/BookStore/v1/Books";

    @Test
    public void testStatusCode() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(DEMO_QA_BOOKS_URL);

        HttpResponse response = httpClient.execute(httpGet);

        Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
    }

    @Test
    public void testRequestContainBookWithSpecificTitle() throws IOException, ParseException {
        String bookTitlePart = "Git";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(DEMO_QA_BOOKS_URL);

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(EntityUtils.toString(entity));
        JSONArray jsonBooks = (JSONArray) jsonObject.get("books");

        List<String> titlesWithSpecificPart = IntStream.range(0, jsonBooks.size())
                .mapToObj(index -> (JSONObject) jsonBooks.get(index))
                .map(json -> json.get("title").toString())
                .filter(title -> title.contains(bookTitlePart))
                .collect(Collectors.toList());

        Assertions.assertTrue(titlesWithSpecificPart.size() > 0);
    }
}
