package algorithm.array.binary.search;

/**
 * @author nizy
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @date 2021/3/13 3:39 下午
 */
public class FindMin {

    /**
     * 题解:
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/yi-wen-jie-jue-4-dao-sou-suo-xuan-zhuan-pai-xu-s-3/
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] <= nums[end]) {
                return nums[start];
            }
            int mid = start + ((end - start) >> 2);
            // 此时nums[mid]有可能是最小值，因此mid要进入到下一次循环
            if (nums[start] > nums[mid]) {
                end = mid;
                //此时nums[mid]是递增序列的一部分
            } else if (nums[start] <= nums[mid]){
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int [] nums = {3,4,5,1,2};
        System.out.println(findMin.findMin(nums));
    }
}
