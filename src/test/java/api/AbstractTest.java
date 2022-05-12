package api;

import api.client.BookClient;
import org.junit.jupiter.api.BeforeEach;

public class AbstractTest {

    public BookClient client;

    @BeforeEach
    public void getClient(){
        client = new BookClient();
    }
}
