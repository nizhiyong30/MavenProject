package algorithm.dp;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 最长公共序列，
 *
 * @author kelai 2020-05-30 22:15
 */
public class LonggestCommonSubSeq {

    public static int[][] getDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], (s1.charAt(i) == s2.charAt(0) ? 1 : 0));
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], (s1.charAt(0) == s2.charAt(j) ? 1 : 0));
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), (s1.charAt(i) == s2.charAt(j) ? dp[i - 1][j - 1] + 1 : 0));
            }
        }
        return dp;
    }

    public static int getDP1(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        String moreString = m >= n ? s1 : s2;
        String lessString = m < n ? s1 : s2;
        int less = Math.min(m, n);
        int more = Math.max(m, n);
        int[] dp = new int[less + 1];
        for (int i = 1; i <= more; i++) {
            // pre代表二维数组中的dp[i-1][j-1]
            // 对于j+1来讲，就是更新前的dp[j];
            int pre = 0;
            for (int j = 1; j <= less; j++) {
                int tmp = dp[j];
                if (moreString.charAt(i - 1) == lessString.charAt(j - 1)) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                pre = tmp;
            }
        }
        return dp[less];
    }


    public static String lcss(String s1, String s2) {
        if (StringUtils.isEmpty(s1) || StringUtils.isEmpty(s2)) {
            return "";
        }
        int[][] dp = getDP(s1, s2);
        StringBuilder s = new StringBuilder();
        int m = s1.length() - 1;
        int n = s2.length() - 1;
        int index = dp[m][n];
        while (index > 0) {
            if (m > 0 && dp[m - 1][n] == dp[m][n]) {
                m--;
            } else if (n > 0 && dp[m][n - 1] == dp[m][n]) {
                n--;
            } else {
                s.append(s1.charAt(m));
                index--;
                m--;
                n--;
            }
        }
        return s.toString();
    }



    public static void main(String[] args) {
        String s1 = "abcba";
        String s2 = "abcbcba";
        System.out.println(getDP1(s1, s2));
    }
}
