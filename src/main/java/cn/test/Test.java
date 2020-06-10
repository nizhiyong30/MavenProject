package cn.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Iterables;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.xerial.snappy.Snappy;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by nizy on 2019/1/9.
 */
public class Test {
    private final static String DISTANCE = "_distance";

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (int num : stack) {
            System.out.println(num);
        }
        stack.pop();
    }

    @org.junit.Test
    public void test() {
      String s = "{\"data\":[{\"avatar\":\"a.jpg\",\"signature\":\"个人简介个人简介个人简介\",\"enterpriseName\":\"value\",\"nickname\":\"value\",\"username\":\"dxy_test\",\"userId\":1234}],\"message\":\"value\",\"code\":\"success\"}";
      JSONObject jsonObject = JSONObject.parseObject(s);
      JSONArray array = jsonObject.getJSONArray("data");
      for (int i = 0; i < array.size(); i++ ) {
          JSONObject obj = array.getJSONObject(i);
          Map<String, Object> map = obj.getInnerMap();
      }


    }

    public static String getString(String path) {
        try {
            ArrayList<String> strArray = new ArrayList<String>();
            File filename = new File(path);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            return line;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isPrime(Long num) {
        Long i;
        for (i = 2L; i < num - 1; i++) {
            if (num % i == 0) {
                break;
            }
        }
        if ((i == num - 1) || (num == 2)) {
            return true;
        } else {
            return false;
        }

    }

    public static void codestastic() throws IOException {
        String path = "/Users/nizhiyong/Downloads/topn_es.txt";
        Pattern pattern1 = Pattern.compile("Cascade:@?(.*)\"");
        int totalLine = 0;
        int codeLine = 0;
        Map<String, Integer> result = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                totalLine++;
                Matcher matcher = pattern1.matcher(lineTxt);
                if (matcher.find()) {
                    String code = matcher.group(1);
                    if (StringUtils.isNotBlank(code)) {
                        codeLine++;
                        Integer count = null;
                        if ((count = result.get(code)) == null) {
                            result.put(code, 1);
                        } else {
                            result.put(code, count + 1);
                        }
                    }
                }
            }
            br.close();
            System.out.println(totalLine);
            System.out.println(codeLine);
            List<Map.Entry<String, Integer>> list = new ArrayList<>(result.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            for (Map.Entry<String, Integer> entry : list) {
                System.out.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
    }


}
