package leetcode.round1.dp;

/**
 * @author nizy
 * @date 2021/11/21 2:39 下午
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curValue = nums[i];
            int curMaxValue = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                curValue = curValue * nums[j];
                curMaxValue = Math.max(curMaxValue, curValue);
            }
            result = Math.max(result, curMaxValue);
        }
        return result;

    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int[] nums = new int[]{-2,3,-4};
        maxProduct.maxProduct(nums);
    }
}
