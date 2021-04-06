package algorithm.dp;

import algorithm.util.CommonUtils;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author kelai 2020-05-30 18:25
 */
public class LonggestIncreadeSubSeq {


    /**
     * 最长递增子序列, leetcode第300题。程序员代码面试指南第202页。
     * dp[i]表示以array[i]为结尾时的最长递增子序列序列的长度。dp[i]=max{dp[j]+1(0<=j<i,arr[j]<arr[i])}
     * 从arr[j,j=(0..i-1)]中选择比arr[i]小且dp[j]最大的数。
     *
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

    /**
     * 维护一个列表 tailstails，其中每个元素 tails[k]tails[k] 的值代表 长度为 k+1k+1 的子序列尾部元素的值。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }


    public static int[] LISWithSmallest(int[] arr) {
        // write code here
        int dp[] = new int[arr.length];
        // index[i]表示最长递增子序列的长度为i时，符合条件的最长递增子序列最后一个字符最小的字符所在的下标。
        int index[] = new int[arr.length];
        int lastIndex = -1;
        Arrays.fill(dp, 1);
        Arrays.fill(index, -1);
        index[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if (index[dp[i]] == -1) {
                index[dp[i]] = i;
            } else {
                index[dp[i]] = arr[i] > arr[index[dp[i]]] ? index[dp[i]] : i;
            }
        }
        for (int j = index.length - 1; j >= 0; j--) {
            if (index[j] != -1) {
                lastIndex = index[j];
                break;
            }
        }
        int[] result = new int[dp[lastIndex]];
        int resultIndex = result.length - 1;

        result[resultIndex--] = arr[lastIndex];
        int subSequenceLength = dp[lastIndex] - 1;
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (subSequenceLength == 0) {
                break;
            }
            if (dp[i] == subSequenceLength) {
                result[resultIndex--] = arr[i];
                subSequenceLength--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2,1,5,3,6,4,8,9,7};
        System.out.println(LISWithSmallest(array));
//        CommonUtils.printArray(array);
//        System.out.println();
//        int[] result = getLIS(array);
//        CommonUtils.printArray(result);
//        Queue<Integer> queue = new LinkedBlockingQueue<>();

    }
}
