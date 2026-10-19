package indi.sly.testtry;

import indi.sly.testtry.t20260915.TextRecord;
import indi.sly.testtry.t20261005.ITestActor;
import indi.sly.testtry.t20261005.TestDTO;
import io.dapr.actors.ActorId;
import io.dapr.actors.client.ActorClient;
import io.dapr.actors.client.ActorProxyBuilder;
import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import io.dapr.client.DaprInvokeHttpClient;
import io.dapr.config.Properties;
import io.dapr.config.Property;
import io.dapr.exceptions.DaprException;
import tools.jackson.databind.ObjectMapper;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class TestApplication2 {
    static void main(String[] args) {
        Map<Property<?>, String> properties = Map.of(Properties.HTTP_ENDPOINT, "http://10.28.0.16:3501", Properties.GRPC_ENDPOINT, "10.28.0.16:50002");

        actorTest(properties);
    }

    static void invokeTest(Map<Property<?>, String> properties) {
        try (DaprClient client = new DaprClientBuilder().withPropertyOverrides(properties).build()) {
            DaprInvokeHttpClient invoker = client.invokeHttpClient("myapps");

            ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writeValueAsString(new TextRecord("123123"));

            HttpRequest request = invoker.newRequestBuilder("daprinvoke").header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
                    //.POST(DaprBodyPublishers.json(new TestActor.SV("231231")))
                    .build();

            HttpResponse<String> response = invoker.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

//            HttpRequest request = invoker.newRequestBuilder("daprinvoke")
//                    .header("Content-Type", "text/plain; charset=UTF-8")
//                    .POST(HttpRequest.BodyPublishers.ofString("123", StandardCharsets.UTF_8))
//                    .build();

            System.out.println("状态码: " + response.statusCode());

            TextRecord textRecord = mapper.readValue(response.body(), TextRecord.class);

            System.out.println(textRecord.text());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    static void actorTest(Map<Property<?>, String> properties) {
        try (ActorClient client = new ActorClient(new Properties(properties))) {
            ActorProxyBuilder<ITestActor> builder = new ActorProxyBuilder<>(ITestActor.class, client);

            ActorId actorId = new ActorId("ActorInstance1");

            ITestActor actor = builder.build(actorId);

            TestDTO testDTO = new TestDTO();
            testDTO.setText("test");

            String result = actor.test(testDTO);

            System.out.println(result);
        } catch (DaprException e) {
            System.err.println(e.getMessage());
        }
    }
}
