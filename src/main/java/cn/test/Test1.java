package cn.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.xerial.snappy.Snappy;
import sun.nio.ch.DirectBuffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by nizy on 2019/4/16.
 */
@Slf4j
public class Test1 {


    public static void main(String[] args) throws Exception {
       List<List<String>> list = new ArrayList<>();
       for(int i = 0; i < 5; i++) {
           List<String> innerList = new ArrayList<>();
           innerList.add(i + "");
           innerList.add(i + "" + i);
           list.add(innerList);
       }
       List result = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
       System.out.println(result);
    }
}


