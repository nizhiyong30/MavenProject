package leetcode.round1.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/11/25 10:50 下午
 */
public class GenerateParenthesis {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        backTrace(n, n, "");
        return res;
    }

    public void backTrace(int leftCount, int rightCount, String currStr) {
        if (leftCount > rightCount) {
            return;
        }
        if (leftCount < 0) {
            return;
        }
        if (rightCount < 0) {
            return;
        }
        if (rightCount == 0 && leftCount == 0) {
            res.add(currStr);
        }
        backTrace(leftCount - 1, rightCount, currStr + "(");
        backTrace(leftCount, rightCount - 1, currStr + ")");
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
        System.out.println(generateParenthesis.res);
    }
}

