package algorithm.array.binary.search;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author nizy
 * @date 2021/3/9 7:16 下午
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return search(nums, start, mid - 1, target);
            } else {
                return search(nums, mid + 1, end, target);
            }
        }
        return start;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert.searchInsert(nums, 5));

    }

}
