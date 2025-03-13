package cn.concurrentTest;

/**
 * @author nizy
 * @date 2021/8/31 下午3:34
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();


    public static void main(String[] args) {
        threadLocal1.set(1);
    }


}
