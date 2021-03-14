package algorithm.dp;

/**
 * @author nizy
 * @date 2021/2/22 7:07 下午
 */
public class MaximalSquare {
    public static int solution(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
        int result = dp[0][0];
        for(int i = 1; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            result = Math.max(result, dp[0][i]);
        }
        for(int i = 1; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            result = Math.max(result, dp[i][0]);
        }
        for (int i = 1; i <  matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + matrix[i][j] - '0';
                result = Math.max(dp[i][j], result);
            }
        }
        return result * result;
    }

    /**
     *  if(matrix[i][j] == '0') {
     *                     dp[i][j] = 0;
     *                 }  else if(dp[i-1][j] == 0 || dp[i][j-1] == 0 || dp[i-1][j-1] == 0) {
     *                     dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
     *                 } else {
     *                     dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) +1;
     *                 }
     *                 result = Math.max(dp[i][j], result);
     * @param args
     */
    public static void main(String[] args) {
        char[][] array = {{'1','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','1','1','1'}};
        System.out.println(solution(array));
    }
}
