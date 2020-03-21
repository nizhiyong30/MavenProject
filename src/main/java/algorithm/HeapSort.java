package algorithm;

import algorithm.util.CommonUtils;

public class HeapSort {

    public static void heapAdjust(int[] array, int index, int length) {
        for (int i = 2 * index + 1; i < length; i = i * 2 + 1) {
            int value = array[index];
            if (i < length -1 && array[i + 1] > array[i]) {
                i++;
            }
            if (value >= array[i]) {
                break;
            }
            array[index] = array[i];
            array[i] = value;
            index = i;
        }
    }

    public static void minHeapAdjust(int[] array, int index, int length) {
        for (int i = 2 * index + 1; i < length; i = 2 * i +1) {
            int value = array[index];
            if (i < length -1 && array[i]  > array[i + 1]) {
                i++;
            }
            if (value <= array[i]) {
                break;
            }
            array[index] = array[i];
            array[i] = value;
            index = i;
        }
    }

    public static void heapSort(int[] array) {
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            minHeapAdjust(array, i, length);
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[array.length - i];
            array[array.length - i] = array[0];
            array[0] = temp;
            minHeapAdjust(array, 0, array.length - i);
        }
    }

    public static void topnK(int[] array, int k) {
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapAdjust(array, i, length);
        }
        for (int i = 1; i <= k; i++) {
            int temp = array[array.length - i];
            array[array.length - i] = array[0];
            System.out.println(array[0]);
            array[0] = temp;
            heapAdjust(array, 0, array.length - i);
        }
    }

    public static void main(String[] args) {
        int[] array = CommonUtils.generateRandomArray(10);
        CommonUtils.printArray(array);
        System.out.println();
        topnK(array, 5);
        System.out.println();
        CommonUtils.printArray(array);
    }
}
