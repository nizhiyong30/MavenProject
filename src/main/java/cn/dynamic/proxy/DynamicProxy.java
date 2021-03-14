package cn.dynamic.proxy;

import java.lang.reflect.Proxy;

/**
 * @author nizy
 * @date 2021/1/18 6:16 下午
 */
public class DynamicProxy {
    public static void main(String[] agrs){
        RealSubject realSubject = new RealSubject();
        ProxyHandler handler = new ProxyHandler(realSubject);
        Subject subject =(Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), handler);
        subject.doSomething();
        subject.request();
    }
}
