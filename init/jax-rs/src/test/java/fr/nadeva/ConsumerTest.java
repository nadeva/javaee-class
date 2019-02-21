package fr.nadeva;

import com.google.gson.Gson;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.StringReader;

import static junit.framework.TestCase.assertEquals;


public class ConsumerTest {


    @Test
    public void jaxRSClient() {

        int portNumber = FluentServer.startServer(new Book("Passionate Programmer", 19.99d));
        Client client = ClientBuilder.newClient();

        Response response = client.target("http://localhost:" + portNumber + "/").request("application/json").get();

        System.out.println("Status : " + response.getStatus());
        final String entity = response.readEntity(String.class);
        System.out.println("Entity : " + entity);

        long start = System.currentTimeMillis();
        Book bookUsingJsonProcessor = readEntityWithStandardAPI(entity);
        System.out.println("JsonProcessor parsed in " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        Book bookUsingGson = readEntityWithGson(entity);
        System.out.println("Gson parsed in " + (System.currentTimeMillis() - start) + " ms");


        assertEquals("Books should be the same", bookUsingJsonProcessor, bookUsingGson);
        assertEquals("Book name", "Passionate Programmer", bookUsingGson.getTitle());
        assertEquals("Book price", 19.99d, bookUsingGson.getPrice());

    }

    private Book readEntityWithStandardAPI(String entity) {
        JsonReader reader = Json.createReader(new StringReader(entity));
        JsonObject jsonObject = reader.readObject();
        reader.close();
        return new Book(jsonObject.getString("title"), jsonObject.getJsonNumber("price").doubleValue());
    }

    private Book readEntityWithGson(String entity) {
        return new Gson().fromJson(entity, Book.class);
    }
}
