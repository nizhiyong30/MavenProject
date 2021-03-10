package algorithm.array.sort;

/**
 * @author nizy
 * @date 2021/3/8 2:07 下午
 */
public class QuickSort {

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(nums, start, end);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);

    }

    public int partition(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= pivot) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] < pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println();
    }
}
