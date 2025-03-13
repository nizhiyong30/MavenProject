package cn;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kelai 2020-07-25 11:43
 */
public class concurrent {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();


    public static void main(String[] args) throws InterruptedException{
    }
}
