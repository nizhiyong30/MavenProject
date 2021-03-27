package cn.classLoader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nizy
 * @date 2021/1/28 7:33 下午
 */
public class MyClassLoaderParentFirst extends ClassLoader{

    private Map<String, String> classPathMap = new HashMap<>();

    ClassLoader jdkClassLoader = null;

    public MyClassLoaderParentFirst(ClassLoader jdkClassLoader) {
        this.jdkClassLoader = jdkClassLoader;
        classPathMap.put("cn.classLoader.TestA", "/Users/nizhiyong/private/classes/TestA.class");
        classPathMap.put("cn.classLoader.TestB", "/Users/nizhiyong/private/classes/TestB.class");
    }

//    @Override
//    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
//        Class result = null;
//        String classPath = classPathMap.get(name);
//        if (classPath != null) {
//            File file = new File(classPath);
//            if (!file.exists()) {
//                throw new ClassNotFoundException();
//            }
//
//            byte[] classBytes = getClassData(file);
//            if (classBytes == null || classBytes.length == 0) {
//                throw new ClassNotFoundException();
//            }
//            return defineClass(classBytes, 0, classBytes.length);
//        } else {
//            try {
//                //这里要使用 JDK 的类加载器加载 java.lang 包里面的类
//                result = jdkClassLoader.loadClass(name);
//            } catch (Exception e) {
//                //忽略
//            }
//            return result;
//        }
//    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class result = null;
        try {
            //这里要使用 JDK 的类加载器加载 java.lang 包里面的类
            result = jdkClassLoader.loadClass(name);
        } catch (Exception e) {
            //忽略
        }
        if (result != null) {
            return result;
        }
        String classPath = classPathMap.get(name);
        File file = new File(classPath);
        if (!file.exists()) {
            throw new ClassNotFoundException();
        }

        byte[] classBytes = getClassData(file);
        if (classBytes == null || classBytes.length == 0) {
            throw new ClassNotFoundException();
        }
        return defineClass(classBytes, 0, classBytes.length);
    }

    // 重写了 findClass 方法
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = classPathMap.get(name);
        File file = new File(classPath);
        if (!file.exists()) {
            throw new ClassNotFoundException();
        }
        byte[] classBytes = getClassData(file);
        if (classBytes == null || classBytes.length == 0) {
            throw new ClassNotFoundException();
        }
        return defineClass(classBytes, 0, classBytes.length);
    }

    private byte[] getClassData(File file) {
        try (InputStream ins = new FileInputStream(file); ByteArrayOutputStream baos = new
                ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[] {};
    }
}
