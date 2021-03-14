package algorithm.dp;

/**
 * 打家劫舍，leetcode第198题
 * https://leetcode-cn.com/problems/house-robber/
 * dp[i]表示以第i间房子为最后一间房子时,偷取的最大金额
 * dp[i] = max(dp[i-2]+num[i], dp[i-1])
 * @author nizy
 * @date 2021/2/23 6:15 下午
 */
public class Rob {
    public static int solution(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            int num = nums[i];
            dp[i] = Math.max((dp[i-2] + num), dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        System.out.println(solution(nums));
    }
}
