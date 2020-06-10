package algorithm.array;

import java.util.Queue;

/**
 * @author kelai 2020-06-06 09:59
 */
public class TwoArraySort {
    public static void solution(int[] array1, int[] array2) {
        int index = array1.length - 1;
        int indexArray1 = array1.length - array2.length - 1;
        int indexArray2 = array2.length - 1;
        while (indexArray1 >= 0 && indexArray2 >= 0 && index >= 0) {
            array1[index--] = array1[indexArray1] <= array2[indexArray2] ? array2[indexArray2--] : array1[indexArray1--];
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
        int[] array2 = {2, 4, 6, 8, 10};
        solution(array1, array2);
        System.out.println(array1);
    }
}
