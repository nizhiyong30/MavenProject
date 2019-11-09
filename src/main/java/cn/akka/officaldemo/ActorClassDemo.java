package cn.akka.officaldemo;

import akka.actor.AbstractActor;

public class ActorClassDemo extends AbstractActor {

    public static class Msg1 {
    }

    public static class Msg2 {
    }

    public static class Msg3 {
    }

    public  void main(String[] args) {
        createReceive().onMessage();
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Msg1.class, this::receiveMsg1)
                .match(Msg2.class, this::receiveMsg2)
                .match(Msg3.class, this::receiveMsg3)
                .build();
    }

    private void receiveMsg1(Msg1 msg) {
        // actual work
    }

    private void receiveMsg2(Msg2 msg) {
        // actual work
    }

    private void receiveMsg3(Msg3 msg) {
        // actual work
    }


}
