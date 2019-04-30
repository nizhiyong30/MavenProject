package cn.designpattern.simplefactorypattern;

/**
 * Created by nizy on 2019/4/2.
 */
public class OperatorSimpleFactory {
    public static Operation  addOperation() {
        return new AddOperation();
    }

    public static Operation subOperation() {
        return new SubOperation();
    }
}
