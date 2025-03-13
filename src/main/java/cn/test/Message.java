package cn.test;

import tomcatlearning.HttpServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author nizy
 * @date 2022/2/8 4:05 下午
 */
public class Message {
    private Map<String, List<Integer>> messages = new HashMap<>();
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public Map<String, List<Integer>> getSearchMessages() {
        return messages;
    }

    public void setMessages(String collection, Integer value) {
        List<Integer> messageList = messages.get(collection);
        if (messageList == null || messageList.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            list.add(value);
            messages.put(collection, list);
        } else {
            messages.get(collection).add(value);
        }
    }

    public static void main(String[] args) {
        Message message1 = new Message();
        Message message2 = new Message();
        new Thread(new Task2(message2)).start();
        new Thread(new Task1(message1)).start();

    }

    static class Task1 implements Runnable {
        private Message message;

        public Task1(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            message.setMessages("task1", 1);
            message.setMessages("task1", 2);
            Map<String, List<Integer>> messageMap = message.getSearchMessages();
            try {
                messageMap.forEach((k, v) -> {
                    try {
                        if(countDownLatch.getCount() > 0) {
                            countDownLatch.countDown();
                        };
                        Thread.sleep(1000L);
                        List<Integer> list = message.getSearchMessages().get("task1");
                        List test = new ArrayList(list.subList(0, 1));
                        System.out.println();
                    } catch (Exception e) {
                        e.toString();
                    }
                });
                System.out.println();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    static class Task2 implements Runnable {
        private Message message;

        public Task2(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
                System.out.println("put task2");
                message.getSearchMessages().get("task1").clear();
            } catch (Exception e) {
                e.toString();
            }
        }
    }

}
