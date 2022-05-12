package api.client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookHttpClient extends HttpBaseClient {

    public BookHttpClient() {
        super();
    }

    public List<String> getBooksValuesByKey(String key) {
        List<String> values = new ArrayList<>();
        JSONArray jsonArray = new JSONObject(body).getJSONArray("books");
        for (Object jsonObject : jsonArray) {
            values.add(((JSONObject) jsonObject).getString(key));
        }
        logger.info(values.toString());
        return values;
    }
}
