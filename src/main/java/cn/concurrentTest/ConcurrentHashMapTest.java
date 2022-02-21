package cn.concurrentTest;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nizy
 * @date 2021/9/9 下午5:21
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        Random random = new Random(100);
        for (int i = 0; i < 11; i++) {
            concurrentHashMap.put(random.nextInt() + "", "test");
        }
        concurrentHashMap.put("test", "test");
    }
}
