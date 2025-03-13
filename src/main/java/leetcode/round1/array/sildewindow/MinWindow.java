package leetcode.round1.array.sildewindow;

import java.util.HashMap;

/**
 * @author nizy
 * @date 2021/11/28 11:17 上午
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        int match = 0;
        int left = 0; int right = 0;
        int minLeft = 0; int minRight = Integer.MIN_VALUE;
        int result = s.length();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);

        }
        while(right < s.length()) {
            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            if (windows.get(c).equals(need.get(c))) {
                match++;
            }
            right++;
            while (match == need.size()) {
                if (right - left <= result) {
                    result = right - left;
                    minLeft = left;
                    minRight = right;
                }
                char leftC = s.charAt(left);
                if (windows.containsKey(leftC)) {
                    windows.put(leftC, windows.get(leftC) - 1);
                    if (need.containsKey(leftC)) {
                        if (windows.get(leftC) < need.get(leftC)) {
                            match--;
                        }
                    }
                }
                left++;
            }
        }
        return minRight == Integer.MIN_VALUE ? "" : s.substring(minLeft, minRight);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        minWindow.minWindow("a", "a");
    }
}
