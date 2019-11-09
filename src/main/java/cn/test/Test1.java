package cn.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.xerial.snappy.Snappy;

import java.lang.reflect.Array;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nizy on 2019/4/16.
 */
public class Test1 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        System.out.println(map.get(null));
    }

    @Test
    public void test() {
        String.format("main_part_id:%s", 1);
        System.out.println("xxx");

    }

    public static void listTest(List list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
    }
}
