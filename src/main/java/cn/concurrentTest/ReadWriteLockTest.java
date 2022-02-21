package cn.concurrentTest;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author nizy
 * @date 2021/9/13 下午6:42
 */
public class ReadWriteLockTest {

    @Test
    public void test() throws Exception{
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        readLock.lock();
        new Thread(() -> {
            readLock.lock();
        }).start();
//        Thread.sleep(10000L);
        writeLock.lock();
        readLock.lock();
//        readLock.unlock();
//        writeLock.lock();
//        writeLock.unlock();
    }
}
