package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        char[] c = new char[n * 2];
        return result;
    }

    public void generateAll(int position, char c[], List<String> result) {
        if (position == c.length - 1) {
            if (vaild(c)) {
                result.add(new String(c));
            }
        }
        c[position] = '(';
        generateAll(position + 1, c, result);
        c[position] = ')';
        generateAll(position + 1, c, result);

    }

    public boolean vaild(char[] chars) { ;
        int balance = 0;
        for (char c : chars) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
