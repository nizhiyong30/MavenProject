package cn.akka.akkademo;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import cn.akka.Greet;

/**
 * @author kelai
 * @version 1.0
 * @date 2019-08-01 10:15
 */
public class HelloWorld extends UntypedActor {
    ActorRef greeter;

    @Override
    public void preStart() {
        greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
        System.out.println("Greet Actor Path:" + greeter.path());
        greeter.tell("GREET", getSelf());
    }

    @Override
    public void onReceive(Object msg) {
        if (msg.equals("DONE")) {
            greeter.tell("GREET", getSelf());
            getContext().stop(getSelf());
        }
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("hellodemo");
        ActorRef a = system.actorOf(Props.create(HelloWorld.class));
        System.out.println("HelloWorld Actor Path:" + a.path());
    }
}
