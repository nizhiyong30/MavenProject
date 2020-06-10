package algorithm.array;

/**
 * @author kelai 2020-06-06 15:02
 */
public class GetMinNum {
    public static int getMin(int[] array) {
        int index1 = 0;
        int index2 = array.length - 1;
        int mid = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                mid = index2;
                break;
            }
            mid = ((index2 - index1) >> 1) + index1;
            if (array[index1] == array[index2] && array[index1] == array[mid]) {
                int result = array[index1];
                for (int i = index1 + 1; i < index2; i++) {
                    if (result > array[i]) {
                        return array[i];
                    }
                }
            }
            if (array[mid] >= array[index1]) {
                index1 = mid;
            } else if (array[index2] >= array[mid]) {
                index2 = mid;
            }
        }
        return array[mid];
    }
}
