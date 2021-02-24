package algorithm.dp;

/**
 * leetcode第32题:最长有效括号
 * @author nizy
 * @date 2021/2/23 1:09 下午
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        if (s == null) {
            return -1;
        }
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int max = 0;
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            char left = s.charAt(i);
            for (int j = 1; j < s.length(); j++) {
                char right = s.charAt(j);
                if (left == '(' && right == ')') {
                    dp[i][j] = j - 2 < 0 ? 2 : dp[i][j - 2] + 2;
                } else if (right == ')' && left == ')') {
                    if (j - 1 - dp[i][j - 1] >= 0 && s.charAt(j - 1 - dp[i][j - 1]) == '(') {
                        dp[i][j] = dp[i][j - 1] + 2;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
                max = Math.max(dp[i][j], max);
                left = right;
            }
        }
        return max;
    }

    /**
     * dp[i]表示s(0..i)是否是有效括号。如果不是则为0；如果是，则为有效括号的长度。
     * 如果s(i)='('且s(i-1)=')',则dp[i]=dp[i-2]+2
     * 如果s="()((()))",dp[i]=dp[i-1]+dp[i-1-dp[i-1]-1]+2
     * @param s
     * @return
     */
    public static int longestValidParentheses1(String s) {
        if (s == null) {
            return -1;
        }
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int [] dp = new int[s.length()];
        dp[0] = 0;
        int result = 0;
        char left = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            char right = s.charAt(i);
            if(left == '(' && right == ')') {
                dp[i] = (i-2) > 0 ? dp[i-2] + 2 : 2;
            } else if (left == ')' && right == ')') {
                if (i-1-dp[i-1] >= 0 && s.charAt(i-1-dp[i-1]) == '(') {
                    dp[i] = dp[i-1] + (i-2-dp[i-1] >= 0 ? dp[i-2-dp[i-1]] : 0) + 2;
                }
            }
            result = Math.max(result, dp[i]);
            left = right;
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses1(s));
    }
}
