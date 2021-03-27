package cn.dynamci.compiler;

import com.google.common.collect.Lists;

import javax.tools.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/3/16 4:18 下午
 */
public class Client {

    static String SOURCE_CODE =
            "package cn.dynamci.compiler;\n" +
                    "public class JdkDynamicCompileHelloService implements HelloService{\n" +
            "\n" +
            "    @Override\n" +
            "    public void sayHello(String name) {\n" +
                    "" +
            "        System.out.println(String.format(\"%s say hello [by jdk dynamic compile]\", name));\n" +
            "    }\n" +
            "}";

    /**
     * 编译诊断收集器
     */
    static DiagnosticCollector<JavaFileObject> DIAGNOSTIC_COLLECTOR = new DiagnosticCollector<>();

    public static void main(String[] args) throws Exception {
        // 获取系统编译器实例
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 设置编译参数
        List<String> options = new ArrayList<>();
        options.add("-d");

        options.add("/Users/nizhiyong/private/Study/code/MavenProject/target/classes/cn/dynamci/compiler");
//        options.add("-source");
//        options.add("1.8");
//        options.add("-target");
//        options.add("1.8");
        // 获取标准的Java文件管理器实例
        StandardJavaFileManager manager = compiler.getStandardFileManager(DIAGNOSTIC_COLLECTOR, null, null);
        // 初始化自定义类加载器
        JdkDynamicCompileClassLoader classLoader = new JdkDynamicCompileClassLoader(Thread.currentThread().getContextClassLoader());
        // 初始化自定义Java文件管理器实例
        JdkDynamicCompileJavaFileManager fileManager = new JdkDynamicCompileJavaFileManager(manager, classLoader);
        String packageName = "cn.dynamci.compiler";
        String className = "JdkDynamicCompileHelloService";
        String qualifiedName = packageName + "." + className;
        // 构建Java源文件实例
        CharSequenceJavaFileObject javaFileObject = new CharSequenceJavaFileObject(className, SOURCE_CODE);
        // 添加Java源文件实例到自定义Java文件管理器实例中
        fileManager.addJavaFileObject(
                StandardLocation.SOURCE_PATH,
                packageName,
                className + CharSequenceJavaFileObject.JAVA_EXTENSION,
                javaFileObject
        );
        // 初始化一个编译任务实例
        JavaCompiler.CompilationTask compilationTask = compiler.getTask(
                null,
                fileManager,
                DIAGNOSTIC_COLLECTOR,
                options,
                null,
                Lists.newArrayList(javaFileObject)
        );
        // 执行编译任务
        Boolean result = compilationTask.call();
        System.out.println(String.format("编译[%s]结果:%s", qualifiedName, result));
        Class<?> klass = classLoader.loadClass(qualifiedName);
        Class<?> klass1 = classLoader.loadClass("cn.dynamci.compiler.DefaultHelloService");
        System.out.println(klass1.getClassLoader());
        HelloService instance = (HelloService) klass.getDeclaredConstructor().newInstance();
        instance.sayHello("throwable");
        System.out.println(klass.getClassLoader());
    }
}
