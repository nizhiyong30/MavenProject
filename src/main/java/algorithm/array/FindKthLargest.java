package algorithm.array;

import algorithm.array.sort.QuickSort;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/comments/
 *
 * @author nizy
 * @date 2021/3/8 2:25 下午
 */
public class FindKthLargest {

    public int quickSort(int[] nums, int start, int end, int k) {
        int index = partition(nums, start, end);
        PriorityQueue<Integer> priority = new PriorityQueue<>(k, (a, b) -> b.compareTo(a));
        if (index == k) {
            return nums[index];
        }
        if (k > index) {
            return quickSort(nums, index + 1, end, k);
        } else {
            return quickSort(nums, start, index - 1, k);
        }
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

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,2,4,2,2,3,1,4};
        FindKthLargest quickSort = new FindKthLargest();
        System.out.println(quickSort.findKthLargest(nums, 5));
    }
}
