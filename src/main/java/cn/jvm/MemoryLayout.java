package cn.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author nizy
 * @date 2021/8/31 上午11:12
 */
public class MemoryLayout {

    public static void main(String[] args) {
       Object s = new Object();
       System.out.println(ClassLayout.parseInstance(s).toPrintable());
    }
}
