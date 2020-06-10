package algorithm.array;

/**
 * @author kelai 2020-06-05 23:24
 */
public class RepetationNum {

    public static int solution(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 1;
        int end = array.length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            int count = countRange(array, start, mid);
            if (start == mid) {
                if (count > 1) {
                    return start;
                }
            }
            if (count > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int countRange(int[] nums, int start, int end) {
        int count = 0;
        for (int num : nums) {
            if (num <= end && num >= start) {
                count++;
            }
        }
        return count;
    }
}
