package algorithm;

import algorithm.util.CommonUtils;

/**
 * @author kelai 2020-05-30 14:46
 */
public class TopKWithQuickSort {


    public static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        while (start < end) {
            while (start < end && array[end] >= pivot) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] <= pivot) {
                start ++;
            }
            array[end] = array[start];
        }
       array[start] = pivot;
        return start;
    }

    public static int findKindex(int[] array, int start, int end, int k) {
        if (start == end) {
            return start;
        }

        int partiotion = partition(array, start, end);
        if (partiotion == k - 1) {
            return partiotion;
        } else if (partiotion > k -1){
            return findKindex(array, start, partiotion - 1, k);
        } else {
            return findKindex(array, partiotion + 1, end, k);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = CommonUtils.generateRandomArray(10);
        CommonUtils.printArray(array);
        System.out.println();
        System.out.println(findKindex(array, 0, array.length - 1, 5));
        System.out.println();
        CommonUtils.printArray(array);
    }
}
