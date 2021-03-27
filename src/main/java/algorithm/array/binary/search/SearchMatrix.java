package algorithm.array.binary.search;

/**
 * @author nizy
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @date 2021/3/13 2:17 下午
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd) {
            int rowMid = rowStart + ((rowEnd - rowStart) >> 1);
            if (target > matrix[rowMid][colEnd]) {
                rowStart = rowMid + 1;
            } else if (target == matrix[rowMid][colEnd]) {
                return true;
            } else {
                rowEnd = rowMid - 1;
            }
        }
        if (rowStart == matrix.length) {
            return false;
        }

        while (colStart <= colEnd) {
            int colMid = colStart + ((colEnd - colStart) >> 1);
            if (target > matrix[rowStart][colMid]) {
                colStart = colMid + 1;
            } else if (target < matrix[rowStart][colMid]) {
                colEnd = colMid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix, 3));
    }
}
