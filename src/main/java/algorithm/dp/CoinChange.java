package algorithm.dp;

import java.util.Arrays;

/**
 * @author nizy
 * @date 2021/2/21 11:36 上午
 * leetcode第322题;程序员代码面试指南191页。
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return -1;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i - 1] < 0 || dp[i][j - coins[i - 1]] == Integer.MAX_VALUE) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        int result = dp[coins.length][amount];
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }


    public static int coinChange1(int[] coins, int amount) {

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 4, 9};
        int amount = 12;
        System.out.println(coinChange1(coins, amount));
    }


}
