package cn.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by nizy on 2019/4/26.
 */
public class ProxyHandler implements InvocationHandler {
    private Subject subject;

    public ProxyHandler(Subject subject) {
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object object = null;
        try {
            System.out.println("before");
            object = method.invoke(subject, args);
            System.out.println("after");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return object;
        }
    }
}
