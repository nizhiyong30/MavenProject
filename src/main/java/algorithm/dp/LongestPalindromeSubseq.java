package algorithm.dp;

/**
 * leetcode第5题，最长回文子串
 */
public class LongestPalindromeSubseq {

    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        int max = dp[0][0];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                } else {
                    if (j - i == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return dp[0][length - 1];
    }

    /**
     * p[i][j]表示字符串s从第i个到第j个的子串是否构成回文
     * dp[i][j] = s.charAt(i) == s.charAt(j) ?  dp[i+][j-1] : false
     * 由于dpp[i][j]依赖于dp[i+1][j-1]，因此要从dp[s.length-1][0..s.length-1]开始更新dp数组
     * @param s
     * @return
     */
    public static String solution1(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int left = 0;
        int right = 0;
        int maxLength = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if(dp[i][j]) {
                        if(j - i + 1 > maxLength) {
                            left = i;
                            right = j;
                            maxLength = j - i + 1;
                        }
                    }
               }
            }
        }
        return s.substring(left, right + 1);
    }


    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(solution1(s));
    }
}
