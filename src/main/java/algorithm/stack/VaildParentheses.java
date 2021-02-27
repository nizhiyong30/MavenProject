package algorithm.stack;

import java.util.Stack;

/**
 * @author nizy
 * @date 2021/2/25 1:21 下午
 */
public class VaildParentheses {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c == ']' || c == '}') {
                if (stack.empty() || !judgeValid(c, stack.pop())) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public static boolean judgeValid(char c, char charFromStack) {
        boolean result = false;
        switch (charFromStack) {
            case '(':
                result = (c == ')');
                break;
            case '{':
                result = (c == '}');
                break;
            case '[':
                result = (c == ']');
                break;
            default:
                result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "()[]{})";
        System.out.println(isValid(s));
    }
}
