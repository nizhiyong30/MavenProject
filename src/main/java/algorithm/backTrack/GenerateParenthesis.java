package algorithm.backTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 生成有效括号
 * https://leetcode-cn.com/problems/bracket-lcci/
 * @author nizy
 * @date 2021/3/2 6:29 下午
 */
public class GenerateParenthesis {
    private List<String> result = new ArrayList<>();


    public List<String> generateParenthesis(int n) {
        StringBuilder current = new StringBuilder();
        generate(n, n, current);
        return result;
    }

    /**
     * 方法1
     * 思路:首先将左括号的数量left和右括号的数量right设置为n
     * 当right == left时，此时只能选择左括号；当right > left,此时可以选择右括号。按照该思路，设置好终止条件和其他边界条件，进行回溯。
     * @param left
     * @param right
     * @param current
     */
    public void generate(int left, int right, StringBuilder current) {
        if (left == 0 && right == 0) {
            result.add(current.toString());
        } else if (right > 0 && left >= 0) {
            if (left == right) {
                current.append("(");
                generate(left - 1, right, current);
                current.deleteCharAt(current.length() - 1);
            } else if (left < right) {
                current.append("(");
                generate(left - 1, right, current);
                current.deleteCharAt(current.length() - 1);

                current.append(")");
                generate(left, right - 1, current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    /**
     * 方法2
     * 方法1和方法和思路一样，主要是数据结构不同。
     *
     * @param left
     * @param right
     * @param current
     */
    public void generate2(int left, int right, LinkedList<String> current) {
        if (left == 0 && right == 0) {
            result.add(getString(current));
        } else if (right > 0 && left >= 0) {
            if (left == right) {
                current.addLast("(");
                generate2(left - 1, right, current);
                current.removeLast();
            } else if (left < right) {
                current.addLast("(");
                generate2(left - 1, right, current);
                current.removeLast();

                current.addLast(")");
                generate2(left, right - 1, current);
                current.removeLast();
            }
        }
    }

    public String getString(LinkedList<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("ss");
        stringBuilder.replace(stringBuilder.lastIndexOf("s"), stringBuilder.lastIndexOf("s") + 1, "");
        System.out.println(stringBuilder.toString().length());
//        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
//        System.out.println(generateParenthesis.generateParenthesis(3));
    }


}
