package leetcode.round1.array.binary;

/**
 * @author nizy
 * @date 2021/11/27 10:15 上午
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int leftBound = getLeftBound(nums, target);
        int rightBound = getRightBound(nums, target);
        return new int[]{leftBound, rightBound};
    }

    public int getLeftBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int num = nums[mid];
            if(target > num) {
                start = mid + 1;
            } else if(target == num) {
                end = mid - 1;
            } else {
                end = mid - 1;
            }
        }
        if(start >= nums.length) {
            return -1;
        }
        return nums[start] == target ? start : -1;
    }

    public int getRightBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int num = nums[mid];
            if(target > num) {
                start = mid + 1;
            } else if(target == num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(end < 0) {
            return -1;
        }
        return nums[end] == target ? end : -1;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        searchRange.searchRange(new int[]{1}, 1);
    }
}
