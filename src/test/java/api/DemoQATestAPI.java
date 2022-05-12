package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DemoQATestAPI extends AbstractTest {

    @Test
    public void testExistBookWithSpecificTitle() {
        String demoQABooksUrl = "https://demoqa.com/BookStore/v1/Books";
        String key = "title";
        String bookTitlePart = "Git";

        client.sendGet(demoQABooksUrl);
        Assertions.assertEquals(200, client.getStatusCode());

        client.getBody();
        Assertions.assertTrue(client.getBooksValuesByKey(key).stream().anyMatch(value -> value.contains(bookTitlePart)));
    }
}
