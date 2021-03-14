package cn.innerClass;

public class TestClass {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long value = 3437970264749780116L - 3436304154593853604L;
        long i = 0;
        while (i < value) {
            i += 10000;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static class InnerClass implements InnerInterface {

    }
}
