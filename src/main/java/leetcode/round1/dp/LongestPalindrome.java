package leetcode.round1.dp;

/**
 * @author nizy
 * @date 2021/11/17 7:31 下午
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int[][] dp = new int[s.length()][s.length()];
        dp[0][0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int result = s.charAt(0) == s.charAt(i) ? 1 : 0;
            dp[i][0] = dp[0][i] = result;
        }
        return null;

    }
}
