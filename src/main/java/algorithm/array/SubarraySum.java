package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nizy
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 前缀和
 * @date 2021/3/5 6:18 下午
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        /**
         * map的key表示前缀和
         */
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.getOrDefault(sum - k, 0);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        //若数组为{4,3,-3,4,-3},k为0;此时sum={4,7,4,7,4};
        //此时结果为3，1+2;表示nums[1,2]的和为0，nums[3,4]的和为0，nums[3,4]的和为0，nums[1,4]的和为0;
        int[] nums = {4,3,-2,4,-3};
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(nums, 0));
    }
}
