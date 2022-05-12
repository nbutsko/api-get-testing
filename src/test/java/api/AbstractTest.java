package api;

import api.client.BookHttpClient;
import org.junit.jupiter.api.BeforeEach;

public class AbstractTest {

    public BookHttpClient client;

    @BeforeEach
    public void getClient(){
        client = new BookHttpClient();
    }
}
