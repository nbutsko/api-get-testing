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


public class DemoQATestAPI extends AbstractTest {

    @Test
    public void testStatusCode() {
        String demoQaBooksUrl = "https://demoqa.com/BookStore/v1/Books";
        client.sendGet(demoQaBooksUrl);
        Assertions.assertEquals(200, client.getStatusCode());
        Assertions.assertTrue(client.getBody().contains("Git"));
    }

   /* @Test
    public void testRequestContainBookWithSpecificTitle() throws IOException, ParseException {
        String bookTitlePart = "";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(DEMO_QA_BOOKS_URL);

        HttpResponse response = httpClient.execute(httpGet);
        System.out.println(response.toString());

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
    }*/
}
