package algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode第120题——最小三角形和
 * https://leetcode-cn.com/problems/triangle/
 * 用二维矩阵dp[i][j]处理。注意边界条件d[][0]和dp[n][n]的处理。
 *
 * @author nizy
 * @date 2021/2/21 11:02 下午
 */
public class MinimumTotal {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
//        int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(minimumTotal(triangle));
    }
}
