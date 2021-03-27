package cn.dynamci.compiler;

/**
 * @author nizy
 * @date 2021/3/16 4:12 下午
 */
public class DefaultHelloService implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println(String.format("%s say hello [by default]", name));
    }
}
