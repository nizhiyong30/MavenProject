package algorithm.dp;

public class MaxProfit {

    public static int solution(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int buy = num[0];
        int maxProfit = 0;
        for (int i = 1; i < num.length; i++) {
            if (num[i] < buy) {
                buy = num[i];
                maxProfit = Math.max(num[i] - buy, maxProfit);
            } else {
                maxProfit = Math.max(maxProfit, num[i] - buy);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(12 >> 1);
    }
}
