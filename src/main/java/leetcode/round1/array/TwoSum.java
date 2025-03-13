package leetcode.round1.array;

import java.util.Arrays;

/**
 * @author nizy
 * @date 2021/11/26 10:23 下午
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int sum = nums[start] + nums[end];
            if (target == sum) {
                return new int[]{start, end};
            } else if(target < sum) {
                end--;
            } else {
                start++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.twoSum(new int[]{2,7,11,15}, 9));
    }

}
