package algorithm.dp;

/**
 * @author nizy
 * @date 2021/2/24 7:36 下午
 */
public class NumSquares {
    public int solution(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int num = (int)Math.floor(Math.sqrt(n));
        return -1;
    }
}
