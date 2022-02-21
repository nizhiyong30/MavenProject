package leetcode.round1.array.sort;

import java.util.PriorityQueue;

/**
 * @author nizy
 * @date 2021/12/12 2:36 下午
 */
public class FindKthLargest {

    public int quickSort(int[] nums, int start , int end, int k) {
        int index = partition(nums, start, end);
        if (index == k) {
            return nums[index];
        }
        if (k > index) {
            return quickSort(nums, index + 1, end, k);
        } else {
            return quickSort(nums, start, index - 1, k);
        }
    }

    public int partition(int[] nums, int start , int end) {
        if (start == end) {
            return start;
        }
        int pivot = nums[start];
        while(start < end) {
            while(start < end && nums[end] >= pivot) {
                end--;
            }
            nums[start] = nums[end];
            while(start < end && nums[start] < pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    public int findKthLargest1(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }


    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (a, b) -> {
            return a - b;
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            int num = nums[i];
            int top = priorityQueue.peek();
            if (num > top) {
                priorityQueue.poll();
                priorityQueue.offer(num);
            }
        }
        return priorityQueue.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest2(nums, k);
    }



    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
