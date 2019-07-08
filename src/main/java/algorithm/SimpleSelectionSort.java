package algorithm;

import algorithm.util.CommonUtils;

public class SimpleSelectionSort {
    public static void simpleSelectionSort(int [] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            if(i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = CommonUtils.generateRandomArray(10);
        CommonUtils.printArray(array);
        simpleSelectionSort(array);
        System.out.println();
        CommonUtils.printArray(array);
     }
}
