package leetcode.round1.dp;

/**
 * @author nizy
 * @date 2021/11/20 7:40 下午
 */
public class LengthOfLIS {

    public int[] LIS (int[] arr) {
        // write code here
        if(arr.length < 2) {
            return arr;
        }
        //tails[i]表示长度为i+1时，数组尾部的最小值
        int [] tails = new int[arr.length];
        // maxLengths表示以arr[i]为结尾的最长递增子序列的长度
        int [] maxLengthArray = new int[arr.length];
        //最终最长递增子序列的长度
        int maxLength = 1;
        tails[0] = arr[0];
        maxLengthArray[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int left = 0;
            int right = maxLength - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] > num) {
                    right = mid - 1;
                } else if (tails[mid] == num) {
                    right = mid - 1;
                } if (tails[mid] < num) {
                    left = mid + 1;
                }
            }
            tails[left] = num;
            maxLengthArray[i] = left + 1;
            if (left == maxLength) {
                maxLength++;
            }

        }
        int[] result = new int[maxLength];
        for (int i = arr.length -1, j = maxLength; j>0; i--) {
            if (j == maxLengthArray[i]) {
                result[--j] = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int [] nums = new int[] {2,1,5,3,6,4,8,9,7};
        lengthOfLIS.LIS(nums);
    }
}
