package leetcode.round1.backtrack;

/**
 * @author nizy
 * @date 2021/11/24 10:57 上午
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(find(board, word, 0, i , j)) {
                        return true;
                    };
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, String word, int wordIndex, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return false;
        }
        if (word.charAt(wordIndex) != board[i][j]) {
            return false;
        }
        if (word.length() -1 == wordIndex) {
            return true;
        }
        char c = board[i][j];
        board[i][j] = '.';
        boolean result = find(board, word, wordIndex + 1, i - 1, j) || find(board, word, wordIndex + 1, i + 1, j)
                || find(board, word, wordIndex + 1, i, j - 1) || find(board, word, wordIndex + 1, i, j + 1);
        board[i][j] = c;
        return result;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        boolean result = wordSearch.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB");
        System.out.println(result);
    }
}
