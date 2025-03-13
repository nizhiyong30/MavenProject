package leetcode.round1.backtrack;

/**
 * @author nizy
 * @date 2021/11/25 11:06 下午
 */
public class SolveSudoku {
    boolean flag = false;
    boolean[][] rowVisited;
    boolean[][] colVisited;
    boolean[][][] boxVisited;

    public void solveSudoku(char[][] board) {
        rowVisited = new boolean[board.length][10];
        colVisited = new boolean[board[0].length][10];
        boxVisited = new boolean[3][3][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                   int num = board[i][j] - '0';
                   rowVisited[i][num] = true;
                   colVisited[j][num] = true;
                   boxVisited[i/3][j/3][num] = true;
                }
            }
        }
        backTrace(board, 0 ,0);
        System.out.println(board);
    }

    public boolean backTrace(char[][] board, int row, int col) {
        if (col == board[row].length) {
            col = 0;
            row++;
            if(row == board.length) {
                return true;
            }
        }
        if (board[row][col] == '.') {
            for (int i = 1; i < 10; i++) {
                boolean valid = !rowVisited[row][i] && !colVisited[col][i] && !boxVisited[row / 3][col / 3][i];
                if (valid) {
                    board[row][col] = (char) ('0' + i);
                    rowVisited[row][i] = true;
                    colVisited[col][i] = true;
                    boxVisited[row / 3][col / 3][i] = true;
                    if (backTrace(board, row, col + 1)) {
                        return true;
                    }
                    rowVisited[row][i] = false;
                    colVisited[col][i] = false;
                    boxVisited[row / 3][col / 3][i] = false;
                    board[row][col] = '.';
                }
            }
        } else {
            if (backTrace(board, row, col + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SolveSudoku solveSudoku = new SolveSudoku();
        char[][] board = new char [][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku.solveSudoku(board);

    }

}
