package leetcode.round1.array.binary;

/**
 * @author nizy
 * @date 2021/11/27 5:10 下午
 */
public class FindMin {

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            if(nums[start] <= nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if(nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
         }
        return -1;
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin(new int[]{2,1}));


    }
}

