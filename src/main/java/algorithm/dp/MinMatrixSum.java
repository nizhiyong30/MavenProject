package algorithm.dp;

/**
 * @author kelai 2020-05-30 16:48
 * 给定一个矩阵，从左上角开始每次只能
 * 向右走或者向下走，最后到达右下角的位置，
 * 路径上所有的数字累加起来就是路径和，返回
 * 所有的路径中最小的路径和。
 */
public class MinMatrixSum {

    public int minPathSum1(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row - 1; i++) {
            dp[i][0] = m[i][0] + dp[i - 1][0];
        }
        for (int j = 0; j < col - 1; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[j][i - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    //用一维数组来维护记录最小路径
    public int minPathSum2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }

        int more = Math.max(m.length, m[0].length);
        int less = Math.min(m.length, m[0].length);
        boolean rowMore = m.length == more;
        // 消耗较小的空间
        int[] array = new int[less];
        array[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            array[i] = array[i - 1] + (rowMore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            array[0] = (rowMore ? m[i][0] : m[0][i]) + array[0];
            for (int j = 1; j < less; j++) {
                array[j] = Math.min(array[j], array[i]) + (rowMore ? m[i][j] : m[j][i]);
            }
        }
        return array[less - 1];
    }

}
