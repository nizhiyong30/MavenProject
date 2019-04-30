package cn.designpattern.factorypattern;

import cn.designpattern.simplefactorypattern.Operation;
import cn.designpattern.simplefactorypattern.SubOperation;

/**
 * Created by nizy on 2019/4/2.
 */
public class SubFactory implements Factory{
    @Override
    public Operation createOperation() {
        return new SubOperation();
    }
}
