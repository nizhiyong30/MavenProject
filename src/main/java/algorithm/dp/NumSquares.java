package algorithm.dp;

/**
 * @author nizy
 * @date 2021/2/24 7:36 下午
 */
public class NumSquares {
    public static int solution(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int num = (int) Math.floor(Math.sqrt(n));
        int[][] dp = new int[num + 1][n + 1];
        int[] values = new int[num];
        for (int i = 0; i < num; i++) {
            values[i] = (int) Math.pow((i + 1), 2);
        }
        dp[0][0] = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j - values[i - 1] <0){
                    dp[i][j] = dp[i - 1][j];
                } else{
                    dp[i][j] = Math.min((dp[i][j - values[i - 1]] + 1), dp[i - 1][j]);
                }
            }
        }
        return dp[num][n];
    }

    public static void main(String[] args) {
        System.out.println(solution(13));
    }
}
