package algorithm.dp;

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
                        dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                    }
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return dp[0][length-1];
    }

    public static void main(String[] args) {
        String s = "b";
        System.out.println(solution(s));
    }
}
