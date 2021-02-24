package cn.serializable;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author nizy
 * @date 2021/1/20 11:13 上午
 */
public interface Externalizable extends java.io.Serializable {


    void readObject(ObjectInput in) throws IOException, ClassNotFoundException;
    void writeObject(ObjectOutput out) throws IOException;

}
