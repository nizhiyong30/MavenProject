package cn.current;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * @author nizy
 * @date 2021/10/22 1:55 下午
 */
public class ExecutorTest {

    private static final ExecutorService executorService = newSingleThreadExecutor();

    private static final CountDownLatch count = new CountDownLatch(1);

    public static void main(String[] args) {
        executorService.execute(() -> {
            try {
                System.out.println("ready to await");
                count.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("-------");
    }

}
