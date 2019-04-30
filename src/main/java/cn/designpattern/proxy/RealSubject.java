package cn.designpattern.proxy;

/**
 * Created by nizy on 2019/4/26.
 */
public class RealSubject implements  Subject{
    @Override
    public void doSomething() {
        System.out.println("doing ...");
    }

    @Override
    public void request() {
        System.out.println("request....");
    }
}
