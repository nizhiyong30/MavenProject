package algorithm.dp;

/**
 * @author kelai 2020-05-31 17:33
 */
public class BagProblem {

    public static int solution1(int[] w, int[] v, int capacity) {
        int length = w.length;
        if (length == 0 || capacity == 0) {
            return 0;
        }
        int dp[][] = new int[length][capacity + 1];
        dp[0][0] = 0;
        for (int i = 1; i < capacity + 1; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }
        for (int i = 0; i < length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - w[i]] +  + v[i], dp[i - 1][j - 0]);
                }
            }
        }
        return dp[length - 1][capacity];
    }

    public static int solution2(int[] w, int[] v, int capacity) {
        int dp[] = new int[capacity + 1];
        int length1 = w.length;
        int length2 = v.length;
        dp[0] = 0;
        for (int i = 0; i < length1; i++) {
            for(int j = capacity; j >= 0; j--) {
                if (j >= w[i]) {
                    dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
                }
            }
        }
        return dp[capacity];
    }





    public static void main(String[] args) {
        int[] v = {6, 10, 12};
        int[] w = {1, 2, 3};
        System.out.println(solution2(w, v, 5));
    }
}
