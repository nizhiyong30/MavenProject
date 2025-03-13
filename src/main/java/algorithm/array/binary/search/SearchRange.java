package algorithm.array.binary.search;

/**
 * @author nizy
 * @date 2021/3/9 8:31 下午
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 技巧，
 * 1. 比较时，始终将target放在前面。
 * 2. 将if else判断条件写全，这样可以是思路更清晰。
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int upper = upperBound(nums, target);
        int low = lowerBound(nums, target);
        return new int[]{low, upper};
    }

    //计算下边界
    int lowerBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 2);
            // 寻找下边界，指针还需要往左移动
            if (target == nums[mid]) {
                end = mid - 1;
                // 目标值小于当前值的情况下，指针还需往左移动
            } else if (target < nums[mid]) {
                end = mid - 1;
                // 目标值大于当前的情况，指针需要往右移动
            } else {
                start = mid + 1;
            }
        }
        //想想一下，start == end == mid时，
        // 此时的num[i](i>mid&&i<length)的元素均>=target,num[j](j>=0 && j<mid)的元素,均严格小于target.
        // 当执行完最后一次循环时：
        // 1. 若target == num[mid]，指针还需向左移动，此时right = mid-1;
        // 2. 若target<num[mid]，指针还需向左一定，此时right = mid-1;
        // 3. 若target>nums[mid],指针需向右移动，此时left = mid+1;
        // 若此时left == length时，返回-1 （nums=[2,3,4,5,6], target = 7）;
        // 否则，left必然是满足target<=num[left]的第一个值。因此还需要判断num[left]是否等于target;
        if (start >= nums.length || nums[start] != target) {
            return -1;
        }
        return start;
    }

    //计算上边界
    int upperBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 2);
            // 寻找上边界，指针还需要往右移动
            if (target == nums[mid]) {
                start = mid + 1;
                // 目标值大于当前值的情况下，指针还需往右移动
            } else if (target > nums[mid]) {
                start = mid + 1;
                // 目标值小于当前的情况，指针需要往左移动
            } else {
                end = mid - 1;
            }
        }
        if(end < 0 || nums[end] != target) {
            return -1;
        }
        return end;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int nums[] = {5,7,7,8,8,10};
        int[] result = searchRange.searchRange(nums, 8);
        System.out.println(result[0] + "," + result[1]);
    }
}
