package algorithm;

import java.util.Stack;

public class ValidParentheses {

    public static  boolean isValid(String s) {
        if(s == null && s.length() == 0)  {
            return true;
        }

        int lenth = 0;
        while(s.length() != lenth) {
            lenth = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        return s.length() == 0;
    }

    public static  boolean isValid1(String s) {
        if(s == null && s.length() == 0)  {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (c){
                    case (')'):
                        if(stack.peek() != '(') {
                            return false;
                        } else {
                            stack.pop();
                            break;
                        }
                    case('}'):
                        if (stack.peek() != '{') {
                            return false;
                        } else {
                            stack.pop();
                            break;
                        }
                    case(']'):
                        if (stack.peek() != '[') {
                            return false;
                        } else
                        {
                            stack.pop();
                            break;
                        }
                        default:
                            return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid1("{[{[]}]}"));
    }
}
