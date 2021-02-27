package algorithm.dp.Stock;

/**
 * 121
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author nizy
 * @date 2021/2/25 5:40 下午
 */
public class MaxProfit1 {
    public static int solution(int[] prices) {
        int result = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                result = Math.max(prices[i] - result, result);
            } else if (prices[i] < buy) {
                buy = prices[i];
            }
        }
        String s = "";
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(solution(nums));
    }
}
