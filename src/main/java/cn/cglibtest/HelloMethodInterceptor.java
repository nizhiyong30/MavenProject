package cn.cglibtest;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws  Throwable{
        System.out.println("Before:" + method.getName());
        Object o = methodProxy.invokeSuper(object, objects);
        System.out.println("After:" + method.getName());
        return o;
    }
}
