package algorithm.nowcoder;

import reactor.rx.stream.LiftStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author nizy
 * @date 2021/3/15 8:06 下午
 */
public class GetLeastNumbers {


    private void heap_adjust(List<Integer> nums, int index) {
        for (int i = 2 * index + 1; i < nums.size(); i = i * 2 + 1) {
            if (i < nums.size() - 1 &&nums.get(i + 1) > nums.get(i)) {
                i = i + 1;
            }
            if (nums.get(index) > nums.get(i)) {
                break;
            }
            int temp = nums.get(i);
            nums.set(i, nums.get(index));
            nums.set(index, temp);
        }
    }

    private void buildHeap(List<Integer> nums) {
        for (int i = nums.size() / 2 - 1; i >= 0; i--) {
            heap_adjust(nums, i);
        }
    }



    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> heap = new ArrayList();
        if (k > input.length || k == 0) {
            return new ArrayList<>();
        }
        for (int i = 0; i < k; i++) {
            heap.add(input[i]);
        }
        buildHeap(heap);
        for (int i = k; i < input.length; i++) {
            if (heap.get(0) > input[i]) {
                heap.set(0, input[i]);
                heap_adjust(heap, 0);
            }
        }
        return heap;
    }

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        System.out.println(getLeastNumbers.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4));
    }
}
