package leetcode.round1.dp;

/**
 * @author nizy
 * @date 2021/11/20 4:56 下午
 */
public class Rob2 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int left = nums[start];
        int right = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = right;
            right = Math.max(left + nums[i], right);
            left = temp;
        }
        return right;
    }

    public static void main(String[] args) {
        Rob2 rob2 = new Rob2();
        rob2.rob(new int[]{1,2,3,1});
    }
}
