package algorithm;

import algorithm.util.CommonUtils;

public class QuickSort {

    public int partition(int low, int high, int[] array) {
        int pivotKey = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivotKey) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivotKey) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivotKey;
        return low;
    }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(low, high, array);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = CommonUtils.generateRandomArray(10);
        CommonUtils.printArray(array);
        quickSort.quickSort(array, 0, array.length - 1);
        System.out.println();
        CommonUtils.printArray(array);

    }
}
