package algorithm;

/**
 * @author kelai 2020-05-30 23:39
 */
public class findMedianSortedArrays {

    public static void soultion(int[] array1, int[] array2) {

        int m = array1.length;
        int n = array2.length;
        int index = (m + n) / 2;
        int pre = array1[0];
        int cur = array2[0];
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            while (i < m && array1[i] < array2[j]) {

            }

        }
    }
}
