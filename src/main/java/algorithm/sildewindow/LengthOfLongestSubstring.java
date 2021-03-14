package algorithm.sildewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode第三题:无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 找到之前字符串中以当前字符相同的位置+1，组成新的字符串
 * @author nizy
 * @date 2021/2/24 2:26 下午
 */
public class LengthOfLongestSubstring {
    public int solution(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
