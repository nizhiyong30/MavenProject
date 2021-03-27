package cn.classLoader;

import java.lang.reflect.Method;

/**
 * @author nizy
 * @date 2021/1/28 8:21 下午
 */
public class MyTest {
    public static void main(String[] args) throws Exception {
        MyClassLoaderParentFirst myClassLoaderParentFirst = new MyClassLoaderParentFirst(Thread.currentThread().getContextClassLoader());
        Class testAClass = myClassLoaderParentFirst.loadClass("cn.classLoader.TestA");
        Method mainMethod = testAClass.getDeclaredMethod("main", String[].class);
        mainMethod.invoke(null, new Object[]{args});
    }
}
