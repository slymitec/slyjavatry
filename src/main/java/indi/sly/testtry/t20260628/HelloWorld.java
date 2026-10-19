//package indi.sly.testtry.t20260628;
//
//import org.apache.pekko.actor.typed.ActorRef;
//import org.apache.pekko.actor.typed.Behavior;
//import org.apache.pekko.actor.typed.javadsl.AbstractBehavior;
//import org.apache.pekko.actor.typed.javadsl.ActorContext;
//import org.apache.pekko.actor.typed.javadsl.Behaviors;
//import org.apache.pekko.actor.typed.javadsl.Receive;
//
//public class HelloWorld extends AbstractBehavior<Greet> {
//    public static Behavior<Greet> create() {
//        return Behaviors.setup(HelloWorld::new);
//    }
//
//    private HelloWorld(ActorContext<Greet> context) {
//        super(context);
//    }
//
//    @Override
//    public Receive<Greet> createReceive() {
//        return this.newReceiveBuilder().onMessage(Greet.class, this::onGreet).build();
//    }
//
//    private Behavior<Greet> onGreet(Greet command) {
//        this.getContext().getLog().info("Hello {}!", command.getWhom());
//        ActorRef<Greeted> replyTo = command.getReplyTo();
//        replyTo.tell(new Greeted(command.getWhom(), this.getContext().getSelf()));
//        return this;
//    }
//}