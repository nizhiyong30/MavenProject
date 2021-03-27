package cn.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nizy
 * @date 2021/3/18 6:21 下午
 */
public class ReentrantLockTest {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable(reentrantLock));
        thread1.setName("thread1");
        Thread thread2 = new Thread(new MyRunnable(reentrantLock));
        thread2.setName("thread2");
        Thread thread3 = new Thread(new MyRunnable(reentrantLock));
        thread3.setName("thread3");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
    }
}

class MyRunnable implements Runnable {
    private ReentrantLock reentrantLock;

    public MyRunnable(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        try {
            this.reentrantLock.lock();
            int i = 0;
            while(i < 2) {
                System.out.println(Thread.currentThread().getName());
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                reentrantLock.unlock();
        }
    }
}
