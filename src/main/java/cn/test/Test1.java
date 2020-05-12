package cn.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.xerial.snappy.Snappy;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nizy on 2019/4/16.
 */
@Slf4j
public class Test1 {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//        threadLocal.set(null);
        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());
        Executors.newCachedThreadPool();
    }

        @Test
        public void test () {
            int i = 0;
            try {
                if (i > -1) {
                    return;
                }
            } catch (Exception e) {

            } finally {
                System.out.println(1);
            }

        }

        public static void listTest (List list){
            for (Object obj : list) {
                System.out.print(obj + " ");
            }
        }
    }
