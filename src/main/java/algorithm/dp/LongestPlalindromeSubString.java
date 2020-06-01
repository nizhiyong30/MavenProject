package algorithm.dp;

/**
 * @author kelai 2020-05-31 19:39
 */
public class LongestPlalindromeSubString {

    public static String solution(String s) {
        if (s == null && s.length() == 0) {
            return "";
        }
        int length = s.length();
        int max = 0;
        int index = 0;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                       dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (dp[i][j] == 1) {
                    if (j - i +1 > max) {
                        max = j - i + 1;
                        index = i;
                    }
                }
            }
        }
        return s.substring(index, index + max);
    }

    public static void main(String[] args) {
        String s = "aacdefcaa";
        System.out.println(solution(s));
    }
}
