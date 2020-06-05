package algorithm.dp;

public class MaxValue {

    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static int solution1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[row >= col ? col : row];
        boolean rowMore = row >= col;
        int more = row >= col ? row : col;
        int less = row >=col ? col : row;
        dp[0] = grid[0][0];
        for(int i = 1; i < less; i++) {
            dp[i] = dp[i-1] + (rowMore ? grid[0][i] : grid[i][0]);
        }
        for (int i = 1; i < more; i++) {
            dp[0] = rowMore ? grid[i][0] : grid[0][i];
            for (int j = 1; j < less; j++) {
                dp[j] = Math.max(dp[j], dp[j-1]) + grid[i][j];
            }
        }
        return dp[less-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(solution1(grid));
    }
}
