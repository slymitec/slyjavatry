package indi.sly.testtry;

import indi.sly.testtry.t20261005.TestActor;
import io.dapr.actors.runtime.ActorRuntime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SpringConfiguration.class})
public class TestApplication {
    static void main(String[] args) {
        ActorRuntime.getInstance().registerActor(TestActor.class);

        SpringApplication.run(TestApplication.class, args);
    }
}
