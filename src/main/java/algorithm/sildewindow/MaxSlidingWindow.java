package algorithm.sildewindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nizy
 * @date 2021/2/24 4:40 下午
 */
public class MaxSlidingWindow {
    public int[] solution(int[] nums, int k) {
        if(k < 1 || nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            while(!queue.isEmpty() && queue.peekLast() <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if(i - k == queue.peekFirst()) {
                queue.pollFirst();
            }
            if(i >= k-1) {
                result[index++] = nums[queue.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,4};
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        maxSlidingWindow.solution(nums, 2);
    }
}
