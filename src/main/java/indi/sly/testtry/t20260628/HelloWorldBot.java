//package indi.sly.testtry.t20260628;
//
//import org.apache.pekko.actor.typed.ActorRef;
//import org.apache.pekko.actor.typed.Behavior;
//import org.apache.pekko.actor.typed.javadsl.AbstractBehavior;
//import org.apache.pekko.actor.typed.javadsl.ActorContext;
//import org.apache.pekko.actor.typed.javadsl.Behaviors;
//import org.apache.pekko.actor.typed.javadsl.Receive;
//
//public class HelloWorldBot extends AbstractBehavior<Greeted> {
//    public static Behavior<Greeted> create(int max) {
//        return Behaviors.setup(context -> new HelloWorldBot(context, max));
//    }
//
//    private final int max;
//    private int greetingCounter;
//
//    private HelloWorldBot(ActorContext<Greeted> context, int max) {
//        super(context);
//        this.max = max;
//    }
//
//    @Override
//    public Receive<Greeted> createReceive() {
//        return newReceiveBuilder().onMessage(Greeted.class, this::onGreeted).build();
//    }
//
//    private Behavior<Greeted> onGreeted(Greeted message) {
//        greetingCounter++;
//        this.getContext().getLog().info("Greeting {} for {}", greetingCounter, message.getWhom());
//        if (greetingCounter == max) {
//            return Behaviors.stopped();
//        } else {
//            ActorRef<Greet> from = message.getFrom();
//            from.tell(new Greet(message.getWhom(), getContext().getSelf()));
//            return this;
//        }
//    }
//}