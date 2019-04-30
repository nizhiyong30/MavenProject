package cn.learnguava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Created by nizy on 2018/12/13.
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.01);
        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        System.out.println(filter.mightContain(3));
        System.out.println(filter.mightContain(1000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间: " + (end - start));
    }

}
