package leetcode.round1.array.sildewindow;

/**
 * @author nizy
 * @date 2021/11/28 12:06 下午
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = nums.length + 1;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end < nums.length) {
            sum += nums[end];
            end++;
            while(sum >= target) {
                if (sum >= target) {
                    minLength = Math.min(end - start, minLength);
                }
                sum -= nums[start++];
            }
        }
        return minLength > nums.length ? 0 : minLength;
    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        minSubArrayLen.minSubArrayLen(11, new int[]{1,2,3,4,5});
    }
}
