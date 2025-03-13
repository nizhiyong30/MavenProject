package leetcode.round1.array.binary;

/**
 * @author nizy
 * @date 2021/11/27 12:34 下午
 */
public class RorateArray2 {
    public boolean search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                     start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RorateArray2 rorateArray2 = new RorateArray2();
        System.out.println(rorateArray2.search(new int[]{2,5,6,0,0,1,2}, 0));
    }
}
