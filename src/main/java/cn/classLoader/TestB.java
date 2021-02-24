package cn.classLoader;

/**
 * @author nizy
 * @date 2021/1/28 7:32 下午
 */
public class TestB {
    public void hello() {
        System.out.println("TestB: " + this.getClass().getClassLoader());
    }
}
