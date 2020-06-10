package algorithm.backTrack;

/**
 * @author kelai 2020-06-06 16:03
 */
public class PathInMatrxi {

    public static boolean solution(char[][] board, char[] word) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, char[] word, int index, int i, int j) {
        if (board[i][j] != word[index] || i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return false;
        }
        if (word.length - 1 == index) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean result = dfs(board, word, index + 1, i - 1, j) || dfs(board, word, index + 1, i + 1, j)
                         || dfs(board, word, index + 1, i, j - 1) || dfs(board, word, index + 1, i, j + 1);
        board[i][j] = tmp;
        return false;
    }
}
