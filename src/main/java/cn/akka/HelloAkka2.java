package cn.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class HelloAkka2 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("actor-demo-java");
        ActorRef hello = system.actorOf(Props.create(Hello.class));
        hello.tell("Hello", ActorRef.noSender());
        hello.tell("Bob", ActorRef.noSender());
        hello.tell("Alice", ActorRef.noSender());
        hello.tell("Hola", ActorRef.noSender());
        hello.tell("Alice", ActorRef.noSender());
        hello.tell("Bob", ActorRef.noSender());

    }
}
