package cn.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author nizy
 * @date 2021/1/18 6:16 下午
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
