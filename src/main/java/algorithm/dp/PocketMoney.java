package algorithm.dp;

public class PocketMoney {

    //货币不限张数
    public static int solution(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount + 1;
            // 内层 for 在求所有子问题 + 1 的最小值
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static int solution2(int[] coins, int sum) {
        if (coins == null || coins.length == 0) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (sum == 0) {
            return 1;
        }
        int[][] dp = new int[coins.length][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i < sum + 1; i++) {
            if (i < coins[0]) {
                continue;
            }
            dp[0][i] = dp[0][i - coins[0]];
        }
        for (int i = 1; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j - coins[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }
        return dp[coins.length - 1][sum];
    }

//    public int change(int amount, int[] coins) {
//        if (coins == null || coins.length == 0) {
//            return 0;
//        }
//        if (amount == 0) {
//            return 1;
//        }
//        int[][] dp = new int[coins.length][amount + 1];
//        dp[0][0] = 1;
//        for (int i = 1; i < amount + 1; i++) {
//            if (i - coins[0] < 0) {
//                dp[0][i] = dp[0][i - 1];
//            } else {
//                dp[0][i] =
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amout = 5;
        System.out.println(solution2(coins, amout));
    }
}
