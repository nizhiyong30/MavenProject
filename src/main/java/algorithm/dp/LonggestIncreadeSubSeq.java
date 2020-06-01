package algorithm.dp;

import algorithm.util.CommonUtils;

/**
 * @author kelai 2020-05-30 18:25
 */
public class LonggestIncreadeSubSeq {


    public static int[] getDP(int [] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int dp [] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static int[] getLIS(int[] array) {
        int dp[] = getDP(array);
        // 最长递增子序列最后一个数字在原数组的下标
        int index = 0;
        //最长递增子序列长度
        int maxLength = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                index = i;
            }
        }

        int lis[] = new int[maxLength];
        lis[maxLength-1] = array[index];
        int value = array[index];
        for (int i = index; i >= 0; i--) {
            int curValue = array[i];
            int curLength = dp[i];
            if (curValue < value && curLength == maxLength - 1) {
                value = curValue;
                maxLength = curLength;
                lis[curLength - 1] = value;
            }
        }
        return lis;

    }

    public static void main(String[] args) {
        int[] array = {2,1,5,3,6,4,8,9,7};
        CommonUtils.printArray(array);
        System.out.println();
        int[] result = getLIS(array);
        CommonUtils.printArray(result);

    }
}
