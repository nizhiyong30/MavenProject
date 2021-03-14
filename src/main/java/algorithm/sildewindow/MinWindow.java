package algorithm.sildewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode第76题目，最小覆盖子串。
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author nizy
 * @date 2021/2/24 2:44 下午
 */
public class MinWindow {
    public static String solution(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        int windowLeft = 0;
        int windowRight = s.length();
        int resultLength = s.length() + 1;
        int left = 0;
        int right = 0;
        int matchSize = 0;
        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int value = needMap.getOrDefault(c, 0);
            needMap.put(c, value + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            // 当窗口为满足条件时，右指针向右移动，往窗口添加元素。
            if (needMap.getOrDefault(c, 0) != 0) {
                int value = windowMap.getOrDefault(c, 0);
                windowMap.put(c, value + 1);
                if (windowMap.getOrDefault(c, 0).equals(needMap.getOrDefault(c, 0))) {
                    matchSize++;
                }
            }
            // 当窗口已符合条件时，left指针一直往右移动，使当前窗口不符合条件。
            while (left <= right && matchSize == needMap.size()) {
                // 更新符合条件的最小的串
                if ((right - left + 1) < resultLength) {
                    windowLeft = left;
                    windowRight = right + 1;
                    resultLength = right - left + 1;
                }
                // 如果needMap包含当前最左元素，则需要进行移除，直至当前窗口不符合条件。
                if (needMap.getOrDefault(s.charAt(left), 0) != 0) {
                    char leftChar = s.charAt(left);
                    int value = windowMap.getOrDefault(leftChar, 0);
                    value--;
                    windowMap.put(leftChar, value);
                    // 此时窗口已不符合条件
                    if (windowMap.getOrDefault(leftChar, 0) < needMap.getOrDefault(leftChar, 0)) {
                        matchSize--;
                    }
                }
                left++;
            }
            right++;
        }
        if (resultLength == s.length() + 1) {
            return "";
        }
        return s.substring(windowLeft, windowRight);
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(solution(s, "aaa"));
    }
}
