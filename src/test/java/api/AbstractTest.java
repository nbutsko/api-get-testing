package api;

import api.client.MyClient;
import org.junit.jupiter.api.BeforeEach;

public class AbstractTest {

    MyClient client;

    @BeforeEach
    public void getClient(){
        client = new MyClient();
    }
}
