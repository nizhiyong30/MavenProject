package cn.akka.akkademo;

import akka.actor.UntypedActor;

/**
 * @author kelai
 * @version 1.0
 * @date 2019-08-01 10:06
 */
public class Greeter extends UntypedActor {

    @Override
    public void onReceive(Object msg) {
        if (msg.equals("GREET")) {
            System.out.println("Hello, World");
            getSender().tell("DONE", getSelf());
        } else {

        }
    }
}
