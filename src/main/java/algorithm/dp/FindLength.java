package algorithm.dp;

/**
 * @author nizy
 * @date 2021/2/26 5:32 下午
 */
public class FindLength {
    public static int solution(int[] A, int[] B) {

        int[] moreArray = A.length > B.length ? A : B;
        int[] lessArray = A.length > B.length ? B : A;
        int less = lessArray.length;
        int more = moreArray.length;
        int[] dp = new int[less + 1];
        dp[0] = 0;
        int result = 0;
        for (int i = 0; i < more; i++) {
            int pre = 0;
            for (int j = 0; j < less; j++) {
                int temp = dp[j];
                if (moreArray[i] == lessArray[j]) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = 0;
                }
                pre = temp;
                result = Math.max(result, dp[j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {1,0,0,1,0,0,0,1,0,1};
        int[] array2 = {1,1,0,0,1,1,1,0,0,0};
        System.out.println(solution(array1, array2));
    }
}
