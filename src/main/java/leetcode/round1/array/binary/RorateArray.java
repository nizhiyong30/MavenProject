package leetcode.round1.array.binary;

/**
 * @author nizy
 * @date 2021/11/27 11:38 上午
 */
public class RorateArray {
    public int search(int[] nums, int target) {
        int start =  0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RorateArray rorateArray = new RorateArray();
        System.out.println(rorateArray.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

}
