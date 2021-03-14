package algorithm.backTrack;

/**
 * @author nizy
 * @date 2021/3/1 7:27 下午
 */
public class WordSearch2 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int wordIndex, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }
        if (word.charAt(wordIndex) != board[i][j]) {
            return false;
        }
        if (wordIndex == word.length() - 1) {
            return true;
        }
        char t = board[i][j];
        board[i][j] = '.';
        //不要分开计算，分开计算会增加复杂度
        boolean result = exist(board, word, wordIndex + 1, i - 1, j) || exist(board, word, wordIndex + 1, i + 1, j)
                || exist(board, word, wordIndex + 1, i, j - 1) ||exist(board, word, wordIndex + 1, i, j + 1);
        board[i][j] = t;
        return result;
    }
}
