package algorithm;

import algorithm.util.CommonUtils;

public class InsertSort {
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = 0;
            if (array[i] < array[i - 1]) {
                temp = array[i];
                int j = i-1;
                for (; j >= 0 && array[j] > temp; j--) {
                    array[j+1] = array[j];
                }
                array[j+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = CommonUtils.generateRandomArray(10);
        CommonUtils.printArray(array);
        insertSort(array);
        System.out.println();
        CommonUtils.printArray(array);
    }
}
