package algorithm.dp;

/**
 * @author nizy
 * @date 2021/2/8 5:23 下午
 */
public class Test {

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = (dp[i-1] + nums[i]) > nums[i] ? (dp[i-1] + nums[i]):nums[i];
        }
        int result = dp[0];
        for (int i = 0; i < nums.length; i++) {
            result = dp[i] > result ? dp[i] : result;
        }
        return result;
    }

    public static void main(String[] args) {
       String s = "你";
        System.out.println(s.getBytes().length);
     }
}
