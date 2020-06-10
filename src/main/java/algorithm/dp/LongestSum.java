package algorithm.dp;

/**
 * @author kelai 2020-06-06 16:43
 */

/**
 * 剑指offer第14题剪绳子
 **/
public class LongestSum {

    public static int solution(int length) {
        if (length == 0) {
            return 0;
        }
        if (length == 1 || length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[j] * dp[length - j], dp[j]);
            }
        }
        return dp[length];
    }
}
