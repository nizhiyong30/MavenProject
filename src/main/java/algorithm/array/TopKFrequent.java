package algorithm.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author nizy
 * @date 2021/4/7 6:53 下午
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = o1[1] - o2[1];
                if (result == 0) {
                    result = o2[0] - o1[0];
                }
                return result;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() == k) {
                if (compare(new int[]{entry.getKey(), entry.getValue()}, queue.peek())) {
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            } else {
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        map.forEach((key, value) -> {

        });
        return ret;
    }

    public boolean compare(int[] array1, int[] array2) {
        return array1[1] > array2[1] || array1[0] < array2[0];
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        topKFrequent.topKFrequent(new int []{1,1,1,2,2,3}, 2);
    }
}
