package algorithm.dp;

public class CountPlainDromeSubstrings {

    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        int length = s.length();
        int result = s.length();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        //从右下角开始
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] == 1) {
                    result++;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        System.out.println(solution(s));
    }
}
