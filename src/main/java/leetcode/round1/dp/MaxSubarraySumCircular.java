package leetcode.round1.dp;

/**
 * @author nizy
 * @date 2021/11/21 10:14 下午
 */
public class MaxSubarraySumCircular {
    // (1)答案在数组中间，就是最大子序和。例如[1,-2,3,-2]；
    // (2)答案在数组两边，例如[5,-3,5]最大的子序和就等于数组的总和SUM-最小的子序和
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 0) {
            return nums[0];
        }
        int maxValue = nums[0];
        int curMaxValue = nums[0];
        int minValue = nums[0];
        int curMinValue = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMaxValue = Math.max(nums[i], curMaxValue + nums[i]);
            curMinValue = Math.min(nums[i], curMinValue + nums[i]);
            maxValue = Math.max(maxValue, curMaxValue);
            minValue = Math.min(minValue, curMinValue);
            sum += nums[i];
        }
        return Math.max(maxValue, sum - minValue == 0 ? maxValue : sum - minValue);

    }

    public static void main(String[] args) {
        new MaxSubarraySumCircular().maxSubarraySumCircular(new int[]{5,-3,5});
    }
}
