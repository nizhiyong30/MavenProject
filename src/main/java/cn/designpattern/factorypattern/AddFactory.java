package cn.designpattern.factorypattern;

import cn.designpattern.simplefactorypattern.AddOperation;
import cn.designpattern.simplefactorypattern.Operation;

/**
 * Created by nizy on 2019/4/2.
 */
public class AddFactory implements Factory{
    @Override
    public Operation createOperation() {
        return new AddOperation();
    }
}
