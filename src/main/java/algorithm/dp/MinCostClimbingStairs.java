package algorithm.dp;

/**
 * @author nizy
 * leetcode第746题。使用最小花费爬楼梯。
 * @date 2021/2/26 6:17 下午
 */
public class MinCostClimbingStairs {
    public static int solution(int[] cost) {
        int pre = 0;
        int ppre = 0;
        int result = 0;
        for (int i = 0; i <= cost.length; i++) {
            int preToHere = i - 1 < 0 ? 0 : pre + cost[i - 1];
            int ppreToHere = i - 2 < 0 ? 0 : ppre + cost[i - 2];
            result = Math.min(preToHere, ppreToHere);
            ppre = pre;
            pre = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(solution(cost));
    }
}
