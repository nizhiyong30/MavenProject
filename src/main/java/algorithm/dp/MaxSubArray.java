package algorithm.dp;

public class MaxSubArray {
    public static int solution(int[] nums) {

        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 100, -1, 99, 1};
        System.out.println(solution(nums));
    }
}
