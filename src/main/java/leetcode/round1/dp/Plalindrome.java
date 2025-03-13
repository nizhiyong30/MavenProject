package leetcode.round1.dp;

/**
 * @author nizy
 * @date 2021/11/21 9:31 下午
 */
public class Plalindrome {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (isMatch(s, p, i, j-1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j];
                    }
                } else {
                    if (isMatch(s, p, i, j)) {
                        dp[i][j] = dp[i][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatch(String s, String p, int i, int j) {
//        if (i == 0) {
//            return false;
//        }
        return s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.';
    }

    public static void main(String[] args) {
        Plalindrome plalindrome = new Plalindrome();
        System.out.println(plalindrome.isMatch("aa", "a*"));
    }
}
