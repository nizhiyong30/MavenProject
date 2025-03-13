package cn.concurrentTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nizy
 * @date 2021/8/31 下午4:29
 */
public class ReentrantLockTest {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws Exception{
        Thread.currentThread().setName("nizy");
        new Thread(new MyTask()).start();
        Thread.sleep(3000L);
        reentrantLock.lock();
        System.out.println();
        reentrantLock.unlock();
    }

    public static class MyTask implements Runnable {

        @Override
        public void run(){
            try {
                reentrantLock.lock();
                Thread.sleep(1000000000000000000L);
                Thread.sleep(3000L);
                reentrantLock.unlock();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
