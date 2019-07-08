package algorithm;

import algorithm.util.CommonUtils;

public class TopKAlgorithm {

    public static void topKMaxValue(int[] array, int k) {
        int[] minHeapArray = new int[k];
        for (int i = 0; i < k; i++) {
            minHeapArray[i] = array[i];
        }
        for (int i = 0; i < k; i++) {
            HeapSort.minHeapAdjust(minHeapArray, 0, k);
        }
        CommonUtils.printArray(minHeapArray);
        System.out.println();
        for (int i = k; i < array.length; i++) {
            if (array[i] > minHeapArray[0]) {
                minHeapArray[0] = array[i];
                HeapSort.minHeapAdjust(minHeapArray, 0, k);
            }
        }
        CommonUtils.printArray(minHeapArray);
    }

    public static void main(String[] args) {
        int[] array = CommonUtils.generateRandomArray(10);
        CommonUtils.printArray(array);
        System.out.println();
        topKMaxValue(array, 5);
        System.out.println();
        HeapSort.heapSort(array);
        CommonUtils.printArray(array);

    }
}
