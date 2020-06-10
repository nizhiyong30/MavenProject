package algorithm.array;

/**
 * @author kelai 2020-06-05 21:51
 */
public class YangShiMatrix {
    public static boolean soultion(int num, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0 || array[0].length == 0) {
            return false;
        }
        int col = array[0].length - 1;
        int row = 0;
        while (col >= 0 && row < array.length) {
            if (array[col][row] == num) {
                return true;
            } else if (array[col][row] > num) {
                row++;
            } else {
                col --;
            }
        }
        return false;
    }
}
