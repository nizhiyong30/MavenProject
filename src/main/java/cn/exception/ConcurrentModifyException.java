package cn.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author kelai 2019-11-05 17:14
 */
public class ConcurrentModifyException {
    private static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                list.remove(integer);
            }
        }
    }
}
