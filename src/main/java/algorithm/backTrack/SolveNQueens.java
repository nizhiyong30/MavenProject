package algorithm.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n皇后
 * https://leetcode-cn.com/problems/n-queens/
 * 以行为维度，每到一行，对该行的每一列元素进行选择，如果符合条件，则选择进入下一行。否则直接跳过。
 * @author nizy
 * @date 2021/3/3 2:34 下午
 */
public class SolveNQueens {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[] c = new char[n];
        Arrays.fill(c, '.');
        String originS = new String(c);
        List<String> current = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            current.add(originS);
        }
        find(0, n, current);
        return result;
    }

    public void find(int row, int n, List<String> current) {
        if (row == n) {
            List<String> list = new ArrayList<>(current);
            result.add(list);
        } else if (row < n) {
            for (int i = 0; i < n; i++) {
                if (valid(row, i, current, n)) {
                    String s = current.get(row);
                    String ns = s.substring(0, i) + 'Q' + s.substring(i + 1, s.length());
                    current.set(row, ns);
                    find(row + 1, n, current);
                    current.set(row, s);;
                }
            }
        }
    }

    public boolean valid(int row, int col, List<String> current, int n) {

        // 判断该列是否有'Q'
        for (int i = row; i >= 0; i--) {
            if (current.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // 判断左上角是是否有'Q'
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (current.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        //右上角
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (current.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(4));
    }
}
