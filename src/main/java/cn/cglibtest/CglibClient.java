package cn.cglibtest;

import net.sf.cglib.proxy.Enhancer;

public class CglibClient {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloService.class);
        enhancer.setCallback(new HelloMethodInterceptor());
        HelloService helloService = (HelloService) enhancer.create();
        helloService.sayHello();
    }
}
