package cn.cglibtest;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nizy
 * @date 2021/9/13 下午2:33
 */
public class BitTest {

    @Test
    public void test1() {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.intValue());
    }


    @Test
    public void executorTest() throws Exception{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.submit(() -> {
            System.out.println();
        });
        new CountDownLatch(1).await();
    }
}
