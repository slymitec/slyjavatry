//package indi.sly.testtry.t20260628;
//
//import org.apache.pekko.actor.typed.ActorSystem;
//
//import java.util.concurrent.TimeoutException;
//
//public class Main {
//    static void main() {
//        final ActorSystem<SayHello> system = ActorSystem.create(HelloWorldMain.create(), "hello");
//
//        system.tell(new SayHello("World000"));
//        system.tell(new SayHello("Pekko"));
//
//        system.terminate();
//
//        try {
//            system.close();
//        } catch (TimeoutException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
