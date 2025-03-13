package cn.current;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author nizy
 * @date 2021/9/6 下午6:08
 */
public class AtomicStampedReferenceTest {
    public static void main(String[] args) {
        String s = "123";
        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference(s, 0);
        System.out.println(atomicStampedReference.getReference());
        s = "1234";
//        atomicStampedReference.compareAndSet()
    }
}
