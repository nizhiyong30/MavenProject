package algorithm.array.binary.search;

/**
 * @author nizy
 * @date 2021/3/9 8:31 下午
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int upper = upperBound(nums, target);
        int low = lowerBound(nums, target);
        //不存在情况
        if (upper < low) {
            return new int[]{-1, -1};
        }
        return new int[]{low, upper};
    }

    //计算下边界
    int lowerBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (target <= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    //计算上边界
    int upperBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (target >= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int nums[] = {5, 7, 7, 8, 8, 10};
        int[] result = searchRange.searchRange(nums, 8);
        System.out.println(result);
    }
}
