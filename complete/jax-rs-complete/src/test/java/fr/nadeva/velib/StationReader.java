package fr.nadeva.velib;

import java.io.StringReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;

public class StationReader {

    public static final String API_KEY = "6fa079013355c264eaedbabeb8df6ed38f11a182";

    public static void main(String[] args) {
System.out.println(readStation(72));
    }


    private static Station readStation(int stationId) {

        Client client = ClientBuilder.newClient();

        Response response = client.target("https://api.jcdecaux.com/vls/v1/stations/" + stationId + "?apiKey=" + API_KEY + "&contract=Nantes").request("application/json").get();
//       client.target("https://api.jcdecaux.com/vls/v1/stations/" + stationId + "?apiKey=" + API_KEY + "&contract=Nantes").request("application/json")
//                                       .async()
//               .get(new InvocationCallback<String>() {
//                   @Override
//                   public void completed(String facebookUser) {
//                       // on complete
//
//                       System.out.println("AAAAA "+facebookUser);
//                   }
//
//                   @Override
//                   public void failed(Throwable throwable) {
//                       throwable.printStackTrace();
//                   }
//               });

        System.out.println("Status : " + response.getStatus());
        final String entity = response.readEntity(String.class);
        System.out.println("Entity : " + entity);

        return readEntityUsingJSonProcessingDefaultProvider(entity);


    }

    private static Station readEntityUsingJSonProcessingDefaultProvider(String entity) {
        JsonReader reader = Json.createReader(new StringReader(entity));
        JsonObject jsonObject = reader.readObject();
        reader.close();
        return new Station(
                jsonObject.getJsonNumber("number").intValue(),
                jsonObject.getString("name"),
                jsonObject.getString("address"),
                jsonObject.getJsonNumber("bike_stands").intValue(),
                jsonObject.getJsonNumber("available_bike_stands").intValue(),
                jsonObject.getJsonNumber("available_bikes").intValue(),
                jsonObject.getJsonNumber("last_update").longValue());
    }
}
