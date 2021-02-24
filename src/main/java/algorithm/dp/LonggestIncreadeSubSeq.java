package algorithm.dp;

import algorithm.util.CommonUtils;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author kelai 2020-05-30 18:25
 */
public class LonggestIncreadeSubSeq {


    /**
     * 最长递增子序列, leetcode第300题。程序员代码面试指南第202页。
     * dp[i]表示以array[i]为结尾时，最长序列的长度。dp[i]=max{dp[j]+1(0<=j<i,arr[j]<arr[i])}
     * 从arr[j,j=(0..i-1)]中选择比arr[i]小且dp[j]最大的数。
     * @param array
     * @return
     */
    public static int getDP(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < value) {
                   dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }

    public static int[] getLIS(int[] array) {
        int dp[] = null;
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
        lis[maxLength - 1] = array[index];
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
        int[] array = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        getDP(array);
        CommonUtils.printArray(array);
        System.out.println();
        int[] result = getLIS(array);
        CommonUtils.printArray(result);
        Queue<Integer> queue = new LinkedBlockingQueue<>();

    }
}
