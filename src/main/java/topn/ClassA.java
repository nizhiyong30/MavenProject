package topn;

import java.util.concurrent.CountDownLatch;

/**
 * @author kelai 2020-02-13 16:34
 */
public class ClassA {
    private Object obj = new Object();

    public void test() {
        int num = 100;
        CountDownLatch countDownLatch = new CountDownLatch(num);
        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                while (true) {
                    System.out.println("start");
                    synchronized (ClassA.this) {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            ClassA.this.wait();
                        } catch (Exception e) {
                        } finally {

                        }
                    }
                    System.out.println("end");
                }
            }).start();
        }
    }

    public void notifyTest() {
        synchronized ((ClassA.this)) {
            notify();
        }
    }

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.notifyTest();
        classA.test();
    }
}

