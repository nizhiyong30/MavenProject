package cn.designpattern.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * Created by nizy on 2019/4/26.
 */
public class DynamicProxy {
    public static void main(String[] agrs) throws IOException{
//        bulidProxyClass();
        RealSubject realSubject = new RealSubject();
        ProxyHandler handler = new ProxyHandler(realSubject);
        Subject subject =(Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), handler);
        subject.doSomething();
        subject.request();
    }

    public static void bulidProxyClass() throws IOException {
        byte[] bytes = ProxyGenerator.generateProxyClass("Subject$Proxy", new Class[]{
                Subject.class
        });
        String fileName = System.getProperty("user.dir") + "/out/Subject$Proxy.class";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
