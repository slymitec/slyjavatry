//package indi.sly.testtry.t20260628;
//
//import org.apache.pekko.actor.typed.ActorRef;
//import org.apache.pekko.actor.typed.Behavior;
//import org.apache.pekko.actor.typed.javadsl.AbstractBehavior;
//import org.apache.pekko.actor.typed.javadsl.ActorContext;
//import org.apache.pekko.actor.typed.javadsl.Behaviors;
//import org.apache.pekko.actor.typed.javadsl.Receive;
//
//public class HelloWorldMain extends AbstractBehavior<SayHello> {
//    public static Behavior<SayHello> create() {
//        return Behaviors.setup(HelloWorldMain::new);
//    }
//
//    private final ActorRef<Greet> greeter;
//
//    private HelloWorldMain(ActorContext<SayHello> context) {
//        super(context);
//        this.greeter = this.getContext().spawn(HelloWorld.create(), "greeter");
//    }
//
//    @Override
//    public Receive<SayHello> createReceive() {
//        return this.newReceiveBuilder().onMessage(SayHello.class, this::onStart).build();
//    }
//
//    private Behavior<SayHello> onStart(SayHello command) {
//        ActorRef<Greeted> replyTo = this.getContext().spawn(HelloWorldBot.create(3), command.getName());
//        this.greeter.tell(new Greet(command.getName(), replyTo));
//
//        return this;
//    }
//}