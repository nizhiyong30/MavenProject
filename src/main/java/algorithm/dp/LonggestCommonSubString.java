package algorithm.dp;

/**
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

    public static void main(String[] args) {
        System.out.println(getlonggestCommonSubString("abcde", "bebcd"));
    }
}
