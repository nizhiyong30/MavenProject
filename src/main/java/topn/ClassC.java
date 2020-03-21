package topn;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author kelai 2020-02-13 16:47
 */
public class ClassC extends ClassB{
    @Override
    public void a() {
        System.out.println("b");
    }


    public static void main(String[] args) {
        String s = "[1577,1706]";
        System.out.println();
        List ids = JSONObject.parseArray(s);
        System.out.println(ids.size());
    }
}
