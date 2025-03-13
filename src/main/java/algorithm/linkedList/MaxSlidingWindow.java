package algorithm.linkedList;

import java.util.LinkedList;

/**
 * @author nizy
 * @date 2021/12/12 5:48 下午
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() <= (i - k)) {
                queue.removeFirst();
            }
            if (i + 1 >= k) {
                result[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] result = maxSlidingWindow.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println();
    }
}
