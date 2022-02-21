package algorithm.dp;

/**
 * @author nizy
 * @date 2021/2/22 7:07 下午
 */
public class MaximalSquare {
    public static int solution(char[][] matrix) {
        int result = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i <  matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                }
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
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = -2;
        int num = -2;
        for(int i = 1; i < nums.length; i++) {
            num = Math.max(num + nums[i], nums[i]);
            result = Math.max(num, result);
        }
        System.out.println(result);
    }
}
