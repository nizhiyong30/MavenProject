package algorithm.array.binary.search;

/**
 * @author nizy
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @date 2021/3/13 4:45 下午
 */
public class SearchRorateArray {

    /**
     * 思路：如果nums[mid] == target,直接返回;
     * mid左边和右边必然有一个是连续递增数组，通过连续递增数组判断指针的移动。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 2);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid + 1] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRorateArray searchRorateArray = new SearchRorateArray();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(searchRorateArray.search(nums, 6));
    }
}
