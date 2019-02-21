package cn.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nizy on 2019/1/9.
 */
public class Test {
    Object obj = new Object();

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.toUpperCase());
    }

    public void write(Object obj) {
        this.obj = obj;
    }

}
