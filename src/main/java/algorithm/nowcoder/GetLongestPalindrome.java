package algorithm.nowcoder;

/**
 * @author nizy
 * https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=188&tqId=38292&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * @date 2021/4/1 9:20 下午
 */
public class GetLongestPalindrome {

    public static int getLongestPalindrome(String A, int n) {
        // write code here
        boolean dp[][] = new boolean[n][n];
        int result = 0;
        for (int i =0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(i) == A.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                        result = Math.max((j - i + 1), result);
                    }
                    else {
                        dp[i][j] = dp[i+1][j-1];
                        if (dp[i][j]) {
                            result = Math.max((j - i + 1), result);
                        }
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abc1234321ab";
        int n = 12;
        System.out.println(getLongestPalindrome(s, 12));
    }
}
