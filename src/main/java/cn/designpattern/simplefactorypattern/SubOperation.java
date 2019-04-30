package cn.designpattern.simplefactorypattern;

/**
 * Created by nizy on 2019/4/2.
 */
public class SubOperation implements Operation {
    @Override
    public double getResult(double numberA,double numberB) {
        return numberA - numberB;
    }
}
