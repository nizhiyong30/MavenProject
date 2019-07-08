package algorithm;

import algorithm.util.CommonUtils;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 2; j >= i; j--) {
                if (array[j+1] < array[j]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static void bubbleSort1(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for(int j = 0; j < length - i -1; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] array = CommonUtils.generateRandomArray(10);
        CommonUtils.printArray(array);
        bubbleSort1(array);
        System.out.println();
        CommonUtils.printArray(array);
     }
}
