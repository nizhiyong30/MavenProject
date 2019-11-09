package cn.akka;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class HelloAkka1 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("actor-demo-java");
        ActorRef hello = system.actorOf(Props.create(Hello.class));
        hello.tell("Bob", ActorRef.noSender());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { /* ignore */ }
    }

}

class Hello extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            System.out.println("Hello " + message);
        }
    }
}

