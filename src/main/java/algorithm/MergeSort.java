package algorithm;

import algorithm.util.CommonUtils;

public class MergeSort {

    public static void mergeSort(int low, int high, int[] array) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid, array);
            mergeSort(mid + 1, high, array);
            merge(low, mid, high, array);
        }
    }

    public static void merge(int low, int mid, int high, int[] array) {
        int[] tmpArray = array.clone();
        int index = low;
        int start1 = low;
        int start2 = mid + 1;
        while (start1 <= mid && start2 <= high) {
            while (start1 <= mid && array[start1] <= array[start2]) {
                tmpArray[index++] = array[start1++];
            }
            while (start2 <= high && array[start1] > array[start2]) {
                tmpArray[index++] = array[start2++];
            }
        }
        while (start1 <= mid) {
            tmpArray[index++] = array[start1++];
        }
        while (start2 <= high) {
            tmpArray[index++] = array[start2++];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmpArray[i];
        }

    }

    public static void main(String[] args) {
        int[] array = CommonUtils.generateRandomArray(10);
        CommonUtils.printArray(array);
        mergeSort(0, 9, array);
        System.out.println();
        CommonUtils.printArray(array);
    }
}
