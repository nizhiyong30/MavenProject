package cn.lock;

import cn.concurrentTest.ReentrantLockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nizy
 * @date 2021/9/3 上午11:21
 */
public class ConditionTest {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) throws Exception{
        Thread.currentThread().setName("nizy");
        new Thread(new MyTask()).start();
//        Thread.sleep(30000000000000L);
        Thread.sleep(300L);
        reentrantLock.lock();
        condition.signal();
        System.out.println();
        reentrantLock.unlock();
    }
    static class MyTask implements Runnable {

        @Override
        public void run(){
            try {
                reentrantLock.lock();
//                Thread.sleep(1000000000000000000L);
//                Thread.sleep(3000L);
                condition.await();
                reentrantLock.unlock();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
