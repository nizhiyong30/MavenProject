package algorithm.dp;

import java.util.Arrays;

/**
 * 打家劫舍，leetcode第213题
 * 首尾房间不能同时被抢，那么只有三种不同的情况：1.都不被抢；2.第一件被抢，最后一间不被抢；最后一间被抢，第一件不被抢。
 * @author nizy
 * @date 2021/2/23 7:39 下午
 */
public class Rob2 {
    public static int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(Arrays.copyOfRange(nums, 0, nums.length - 1)), robRange(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public static int robRange(int [] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            int num = nums[i];
            dp[i] = Math.max((dp[i-2] + num), dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
