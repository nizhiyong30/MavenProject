package algorithm.dp;

/**
 * (牛客127题,程序员代码面试指南)
 * https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=117&tqId=37799&rp=1&ru=%2Fta%2Fjob-code-high&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 *
 * @author kelai 2020-05-31 15:41
 */
public class LonggestCommonSubString {

    public static String getlonggestCommonSubString(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int col = length2 - 1;
        int row = 0;
        int end = 0;
        int max = 0;
        while (row < length1) {
            int i = row;
            int j = col;
            int len = 0;
            while (i < length1 && j < length2) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    len++;
                }
                if (len > max) {
                    max = len;
                    end = i;
                }
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        return s1.substring(end - max + 1, end + 1);
    }

    /**
     * dp[i][j]表示以s1为的第i个字符为结尾，以s2的第j个字符为结尾，构成的最长公共子串的大小。
     * dp[i][j] == s.charAt(i) == s.charAt(j) ? dp[i-1][j-1] + 1 : 0;
     * @param str1
     * @param str2
     * @return
     */
    public static String LCS(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 2) {
            return "";
        }
        int dp[][] = new int[str1.length()][str2.length()];
        int max = 0;
        int end = -1;
        for (int i = 0; i < str1.length(); i++) {
            dp[i][0] = str1.charAt(i) == str2.charAt(0) ? 1 : 0;
        }
        for (int j = 0; j < str2.length(); j++) {
            dp[0][j] = str1.charAt(0) == str2.charAt(j) ? 1 : 0;
        }
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    end = i;
                }
            }
        }
        if (end == -1) {
            return "";
        }
        return str1.substring((end - max + 1), end + 1);

    }

    public static void main(String[] args) {
        System.out.println(LCS("2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80", "U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2"));
    }
}
