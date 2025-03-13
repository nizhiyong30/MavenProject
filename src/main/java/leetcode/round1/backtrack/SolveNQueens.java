package leetcode.round1.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/11/24 11:41 上午
 */
public class SolveNQueens {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        find(0, n, board);
        return result;
    }

    public void find(int row, int n, char[][] board) {
        if (row == board.length) {
            result.add(generate(board));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!isValid(row, j, board)) {
                continue;
            }
            char c = board[row][j];
            board[row][j] = 'Q';
            find(row + 1, n, board);
            board[row][j] = c;
        }
    }

    public boolean isValid(int row, int col, char[][] board) {
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; j >= 0 && i >= 0; j--, i--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board[i].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> generate(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            result.add(s);
        }
        return result;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        solveNQueens.solveNQueens(4);

    }
}
