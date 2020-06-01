package algorithm;


import scala.collection.mutable.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kelai 2020-05-31 11:15
 */
public class LengthOfLongestSubstring {


    //left表示当前不重复字符串的左下标；map.(c, i+1),表示当前c的下一个位置才可能不会与c重复。
    public static int solution(String s) {
        int left = 0;
        int max = 0;
        int index = 0;
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (table.containsKey(c)) {
                left = Math.max(left, table.get(c));
            }
            if ((i - left + 1) >= max) {
                max = i - left + 1;
            }
            table.put(c, i + 1);
        }
//        result[0] = max;
//        result[1] = index;
        return max;
    }

    public static void main(String[] args) {
        String s = "abba";
        int result = solution(s);
//        int length = result[0];
//        int start = result[1] - length + 1;
//        System.out.println(s.substring(start, result[1] + 1));

    }
}
