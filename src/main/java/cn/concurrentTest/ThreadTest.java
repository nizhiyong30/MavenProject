package cn.concurrentTest;
import org.junit.Test;

/**
 * @author nizy
 * @date 2021/9/15 下午4:27
 */
public class ThreadTest {

    @Test
    public void threadTest() {
        Thread.currentThread().getName();
        new Thread(() ->{
            Thread.currentThread().getName();
            System.out.println();
        }).start();
    }
}
