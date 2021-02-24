package topn;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author kelai 2020-02-13 16:47
 */
public class ClassC extends ClassB{


    public static void main(String[] args) {
        String a = new StringBuilder("a").append("b").toString();
//        String b = "ab";
        System.out.println(a == a.intern());

        String c = "a";
        String d = "b";
        String e = c + d;
        System.out.println(e == e.intern());

        String i = "a";
        String j = "b";
        String k = c + d;
        String l ="ab";
        System.out.println(k == k.intern());


        String f = "a" + "b";
        String g = "ab";
        System.out.println(f == f.intern());


    }

    @Test
    public void test() {
//        String a = "a";
//        String b = "b";
//        String c = a + b;
//        System.out.println(c == c.intern());


        String c = "a";
        String d = "b";
        String e = c + d;
        System.out.println(e == e.intern());
    }
}
