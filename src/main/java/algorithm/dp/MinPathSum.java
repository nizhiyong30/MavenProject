package algorithm.dp;

/**
 * @author nizy
 * @date 2021/2/18 6:58 下午
 * 最小路径和 leetcode 64题
 */
public class MinPathSum {

    public static int solution(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] += grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] += grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    /**
     * 空间压缩
     * 矩阵:
     * [1 3 1
     *  1 5 1
     *  4 2 1]
     * dp = [1,4,5]
     * 此时，dp[j]表示(0,0)到(0,j)的最小矩阵和
     * 第二行: dp=[2,7,6]
     * 第三行: dp=[6,8,7]
     *
     * @param grid
     * @return
     */
    public static int solution1(int[][] grid) {
        int dp[] = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] = dp[i-1] + grid[0][i];
        }
        // 外层循环的次数等于矩阵的行数减1
        for (int i = 1; i < grid.length; i++) {
            dp[0] = grid[i][0] + dp[0];
            // 内循环更新dp[1]~dp[grid[0].length-1]
            for(int j = 1; j < grid[0].length; j++) {
                //更新前的dp[j]表示(0,0)到(i-1, j)的最短路径
                //更新后的dp[j-1]表示(0,0)到到(i, j-1)的最短路径
                //因此更新dp[j]时，取dp[j]和dp[j-1]的较小值与grid[i][j]的和。
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);
            }
        }
        return dp[grid[0].length - 1];
    }

    /**
     * 空间压缩，
     * @param grid
     * @return
     */
    public static int solution2(int[][] grid) {
        int less = Math.min(grid.length, grid[0].length);
        int more = Math.max(grid.length, grid[0].length);
        boolean rowMore = grid.length == more;
        int dp[] = new int[less];
        dp[0] = grid[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + (rowMore ? grid[0][i] : grid[i][0]);
        }
        for (int i = 1; i < more; i++) {
            dp[0] = dp[0] + (rowMore ? grid[i][0] : grid[0][i]);
            for(int j = 1; j < less; j++) {
                //更新前的dp[j]表示(0,0)到(i-1, j)的最短路径
                //更新后的dp[j-1]表示(0,0)到到(i, j-1)的最短路径
                //因此更新dp[j]时，取dp[j]和dp[j-1]的较小值与grid[i][j]的和。
                dp[j] = (rowMore ? grid[i][j] : grid[j][i])+ Math.min(dp[j], dp[j-1]);
            }
        }
        return dp[less-1];
    }

    public static void main(String[] args) {
        int array[][] = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(solution2(array));
    }
}
