package leetcode.round1.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nizy
 * @date 2021/11/26 11:21 下午
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int num = nums[i];
            int twoTarget = target - nums[i];
            List<List<Integer>> tmpList = threeSum(nums, twoTarget, i+1, num);
            result.addAll(tmpList);
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, int twoTarget, int twoStart, int threeNum) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = twoStart; i < nums.length - 2; i++) {
            if(i > twoStart && nums[i] == nums[i-1]) {
                continue;
            }
            int target = twoTarget-nums[i];
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
                    res.add(threeNum);
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
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{2,2,2,2,2}, 8));
    }
}
