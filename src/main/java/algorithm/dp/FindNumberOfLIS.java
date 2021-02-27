package algorithm.dp;

import java.util.Arrays;

/**
 * @author nizy
 * dp[i]表示以array[i]为结尾时的最长递增子序列的长度
 * length[i]表示以rray[i]为结尾时的最长递增子序列序列的个数
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/dong-tai-gui-hua-jie-zui-chang-zi-xu-lie-zi-chua-4/
 * @date 2021/2/25 8:34 下午
 */
public class FindNumberOfLIS {
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        int[] length = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(length, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        length[i] = length[j];
                        // 第二次找到
                    } else if (dp[j] + 1 == dp[i]) {
                        length[i] = length[i] + length[j];
                    }
                }
            }
        }
        int maxLength = dp[0];
        int result = 0;
        for (int i = 1; i < dp.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLength) {
                result += length[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(solution(nums));
    }
}
