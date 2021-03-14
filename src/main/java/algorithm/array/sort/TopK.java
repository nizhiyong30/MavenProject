package algorithm.array.sort;

import javax.swing.plaf.TabbedPaneUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/3/8 7:35 下午
 */
public class TopK {
    private int k;
    private ArrayList<Integer> heap = new ArrayList<>();

    public TopK(int k) {
        this.k = k;
    }

    public void insert(int value) {
        if (heap.size() < k) {
            heap.add(value);
            if (heap.size() == k) {
                buildHeap();
            }
        } else {
            if (value > heap.get(0)) {
                heap.set(0, value);
                // 需要往下沉
                adjustHeap(0, heap.size());
            }
        }
    }

    public void buildHeap() {
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            adjustHeap(i, heap.size());
        }
    }

    public void adjustHeap(int index, int length) {
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            if (i < length - 1 && heap.get(i) > heap.get(i + 1)) {
                i++;
            }
            if (heap.get(index) < heap.get(i)) {
                break;
            }
            swap(heap, index, i);
            index = i;
        }
    }

    public List getHeap() {
        return this.heap;
    }

    public void sort() {
        for (int i = heap.size() - 1; i > 0; i--) {
            swap(heap, i, 0);
            adjustHeap(0, i);
        }
    }

    public void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    public static void main(String[] args) {
        TopK topK = new TopK(3);
        for (int i = 0; i < 20; i++) {
            topK.insert(i);
        }
        topK.sort();
        System.out.println(topK.getHeap());
    }

}
