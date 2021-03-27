package algorithm.dp;

/**
 * https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * 正则表达式匹配
 * 注意:''和'*'能匹配
 *
 * @author nizy
 * @date 2021/3/7 8:59 下午
 */
public class RegularExpression {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    if (isMatch(s, p, i, j - 1)) {
                        // dp[i][j-2]表示不选择当前通配符时的前置情况;dp[i-1][j]表示选择当前通配符时的前置情况。
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else if (isMatch(s, p, i, j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    public boolean isMatch(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if(p.charAt(j - 1) == '.') {
            return true;
        }
        if (s.charAt(i - 1) == p.charAt(j - 1)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        RegularExpression regularExpression = new RegularExpression();
        System.out.println(regularExpression.isMatch("aa", "a*"));
    }
}
