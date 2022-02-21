package leetcode.round1.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author nizy
 * [[5,4],[6,4],[6,7],[2,3]]
 * @date 2021/11/20 3:26 下午
 */
public class MaxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o2[0] : o1[0] - o2[0];
            }
        });
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = envelopes[i][1];
        }
        return lengthOfLIS(heights);
    }

    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int left = 0;
            int right = result - 1;
            int num = nums[i];
            while(left <= right) {
                //找到dp数组中第一个大于等于num的数。
                int mid = left + (right - right) / 2;
                if(num < dp[mid]) {
                    right = mid - 1;
                } else if(num == dp[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            dp[left] = num;
            if (left == result) {
                result++;
            }
        }
        return result;
    }
}
