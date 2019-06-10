package cn.test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by nizy on 2019/4/16.
 */
public class Test1 {
    public static void main(String[] args) {
        ConcurrentLinkedQueue <String> queue = new ConcurrentLinkedQueue<String>();
        queue.offer("s");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty());

    }
}
