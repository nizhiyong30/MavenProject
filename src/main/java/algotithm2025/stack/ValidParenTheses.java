package algotithm2025.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author kelai 2025-02-26 19:54
 */
public class ValidParenTheses {

    public static boolean isValid(String s) {
        if (s.equals("") || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (pairs.containsKey(s.charAt(i))) {
                if (!stack.isEmpty() && stack.peek().equals(pairs.get(s.charAt(i)))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));

    }
}



