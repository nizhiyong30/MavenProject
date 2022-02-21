package leetcode.round1.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nizy
 * @date 2021/11/26 9:48 下午
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int start = i+1;
            int end = nums.length - 1;
            while(start < end) {
                int leftNum = nums[start];
                int rightNum = nums[end];
                int sum = leftNum + rightNum;
                if(target > sum) {
                    while(start<=end && nums[start] == leftNum) {
                        start++;
                    }
                } else if(target < sum) {
                    while(start<=end && nums[end] == rightNum) {
                        end--;
                    }
                } else {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[start]);
                    res.add(nums[end]);
                    result.add(res);
                    while(start<=end && nums[start] == leftNum) {
                        start++;
                    }
                    while(start<=end && nums[end] == rightNum) {
                        end--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}

