package algorithm.backTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author nizy
 * @date 2021/3/2 7:16 下午
 */
public class LetterCombinations {
    private Map<String, String> letterMap = new HashMap<>();
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        letterMap.put("2", "abc");
        letterMap.put("3", "def");
        letterMap.put("4", "ghi");
        letterMap.put("5", "jkl");
        letterMap.put("6", "mno");
        letterMap.put("7", "qprs");
        letterMap.put("8", "tuv");
        letterMap.put("9", "wxyz");
        find(0, new StringBuilder(), digits);
        return result;
    }

    public void find(int n, StringBuilder current, String digits) {
        if (digits.length() == current.length()) {
            result.add(current.toString());
        } else if (current.length() < digits.length()) {
            String num = digits.substring(n, n + 1);
            String letter = letterMap.get(num);
            for (int i = 0; i < letter.length(); i++) {
                current.append(letter.substring(i, i + 1));
                find(n + 1, current, digits);
                current.deleteCharAt(current.length() - 1);

            }
        }
    }

    public static void main(String[] args) {
       char c = '0' + 0;
        System.out.println(" " + c);
    }
}
