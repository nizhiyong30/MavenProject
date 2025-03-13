package leetcode.round1.array.prefixsum;

import java.util.HashMap;

/**
 * @author nizy
 * @date 2021/11/27 10:19 下午
 */
public class SubarraySum {
    int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // map：前缀和 -> 该前缀和出现的次数
        HashMap<Integer, Integer>
                preSum = new HashMap<>();
        int sum = 0;
        preSum.put(0, 1);
        int result = 0;
        // base case
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int sum_0_j = sum - k;
            if (preSum.containsKey(sum_0_j)) {
                result += preSum.get(sum_0_j);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        subarraySum.subarraySum(new int[]{2,2,2}, 2);
    }
}
