package cn.dynamic.proxy;

/**
 * @author nizy
 * @date 2021/1/18 6:15 下午
 */
public class RealSubject implements Subject{
    @Override
    public void doSomething() {
        System.out.println("doing ...");
    }

    @Override
    public void request() {
        System.out.println("request....");
    }
}
