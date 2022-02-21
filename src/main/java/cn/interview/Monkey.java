package cn.interview;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nizy
 * @date 2022/1/8 10:26 上午
 */
public class Monkey {

    private static AtomicInteger total = new AtomicInteger(9);
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        new Thread(new Task(2, "monkey1")).start();
        new Thread(new Task(3, "monkey2")).start();
    }

    public static class Task implements Runnable {
        private int num;
        private String name;
        public Task(int num, String name) {
            this.name = name;
            this.num = num;
        }
        @Override
        public void run () {
            try {
                cyclicBarrier.await();
                int left = 0;
                while ((left = total.addAndGet(-this.num)) >= 0) {
                    System.out.println(String.format("%s take %s, left %s", this.name, this.num, left));
                }
                left = total.addAndGet(this.num);
                System.out.println(String.format("%s finish, left %s", this.name, left));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
