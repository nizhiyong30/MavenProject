package cn.java8.lambda;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author kelai 2019-11-11 21:04
 */
public class LambdaStudy {
    public static void main(String[] args) {
        String s = "a";
        Predicate<String> predicate = a -> a.equals("hello");
        FunctionDemo<String> functionDemo = b -> System.out.println(b);
        FunctionDemo<String> functionDemo1 = System.out :: println;
        Arrays.asList("a", "b", "c");

        functionDemo.test(s);
    }
}
