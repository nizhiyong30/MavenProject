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

    public MyClassLoaderParentFirst() {
        classPathMap.put("com.java.loader.TestA", "/Users/nizhiyong/private/Study/code/MavenProject/target/classes/cn/classLoader/TestA.class");
        classPathMap.put("com.java.loader.TestB", "/Users/nizhiyong/private/Study/code/MavenProject/target/classes/cn/classLoader/TestB.class");
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
