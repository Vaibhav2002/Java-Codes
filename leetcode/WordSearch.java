package leetcode;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length, column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (find(i, j, board, 0, word.toCharArray())) return true;
            }
        }
        return false;
    }

    public boolean find(int i, int j, char[][] board, int index, char[] word) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (index == word.length) return true;
        if (board[i][j] == '*') return false;
        boolean isValid = false;
        if (board[i][j] == word[index]) {
            char temp = board[i][j];
            board[i][j] = '*';
            if (index == word.length - 1) return true;
            isValid = find(i - 1, j, board, index + 1, word);
            if (isValid) return true;
            isValid = find(i + 1, j, board, index + 1, word);
            if (isValid) return true;
            isValid = find(i, j - 1, board, index + 1, word);
            if (isValid) return true;
            isValid = find(i, j + 1, board, index + 1, word);
            board[i][j] = temp;
        }
        return isValid;
    }
}
