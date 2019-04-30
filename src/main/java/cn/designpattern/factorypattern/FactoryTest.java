package cn.designpattern.factorypattern;

/**
 * Created by nizy on 2019/4/2.
 */
public class FactoryTest {
    public static void main(String[] args) throws Exception {
        Factory addFactory = (Factory) Class.forName("cn.designpattern.factorypattern.AddFactory").newInstance();
        Factory subFactory = (Factory) Class.forName("cn.designpattern.factorypattern.SubFactory").newInstance();
        System.out.println(Class.forName("cn.designpattern.factorypattern.AddFactory").getDeclaredMethods()[0]);
        System.out.println(addFactory.createOperation().getResult(1.0, 2.0));
        System.out.println(subFactory.createOperation().getResult(1.0, 2.0));

    }
}
