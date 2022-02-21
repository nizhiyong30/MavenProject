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
     * 维护一个列表 ，其中每个元素 end[k]的值代表长度为k的子序列尾部元素的值。
     * 对于nums[i],从找出第一个大于nums[i]的end[k]的下标index,并将end[index]更新为nums[i]
     * dp[i]表示以array[i]为结尾时的最长递增子序列序列的长度。
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] end = new int[n + 1];
        int[] dp = new int[n];
        end[len] = nums[0];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > end[len]) {
                end[++len] = nums[i];
                dp[i] = len;
            } else {
                int l = 1, r = len;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (nums[i] > end[mid]) {
                        l = mid + 1;
                    } else if (nums[i] == end[mid]) {
                        r = mid - 1;
                    } else if (nums[i] < end[mid]) {
                        r = mid - 1;
                    }
                }
                //
                if (end[l] > nums[i]) {
                    end[l] = nums[i];
                }
                dp[i] = l;
                len = l;
            }
        }
        int[] resultArray = getLIS(end, len);
        return len;
    }

    public static int[] getLIS(int[] end, int maxLength) {
        int[] result = new int[maxLength];
        for (int i = maxLength; i > 0; i--) {
            result[i - 1] = end[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(lengthOfLIS(array));
//        CommonUtils.printArray(array);
//        System.out.println();
//        int[] result = getLIS(array);
//        CommonUtils.printArray(result);
//        Queue<Integer> queue = new LinkedBlockingQueue<>();

    }
}
