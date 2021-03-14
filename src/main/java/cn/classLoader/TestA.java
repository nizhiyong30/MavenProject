package cn.classLoader;

/**
 * @author nizy
 * @date 2021/1/28 7:31 下午
 */
public class TestA {

    public static void main(String[] args) {
        TestA testA = new TestA();
        testA.hello();
    }

    public void hello() {
        System.out.println("TestA: " + this.getClass().getClassLoader());
        TestB testB = new TestB();
        testB.hello();
    }

}
