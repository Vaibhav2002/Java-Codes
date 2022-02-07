package leetcode;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length, columns = board[0].length;
        int[][] newBoard = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int liveNeighbours = countLiveNeighbours(i, j, board);
                if (board[i][j] == 0)
                    handleDeadCell(i, j, liveNeighbours, newBoard);
                else handleLiveCell(i, j, liveNeighbours, newBoard);
            }
        }
        for (int i = 0; i < rows; i++)
            System.arraycopy(newBoard[i], 0, board[i], 0, columns);
    }

    private void handleLiveCell(int i, int j, int liveNeighbours, int[][] board) {
        if (liveNeighbours < 2 || liveNeighbours > 3) board[i][j] = 0;
        else board[i][j] = 1;
    }

    private void handleDeadCell(int i, int j, int liveNeighbours, int[][] board) {
        if (liveNeighbours == 3) board[i][j] = 1;
        else board[i][j] = 0;
    }

    private int countLiveNeighbours(int i, int j, int[][] board) {
        int diagLeftTop = getValue(i - 1, j - 1, board);
        int diagTopRight = getValue(i - 1, j + 1, board);
        int diagLeftBottom = getValue(i + 1, j - 1, board);
        int diagRightBottom = getValue(i + 1, j + 1, board);
        int top = getValue(i - 1, j, board);
        int bottom = getValue(i + 1, j, board);
        int left = getValue(i, j - 1, board);
        int right = getValue(i, j + 1, board);
        return diagLeftTop + diagTopRight + diagLeftBottom + diagRightBottom + top + bottom + left + right;

    }

    private int getValue(int i, int j, int[][] board) {
        int rows = board.length, columns = board[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= columns) return 0;
        else return board[i][j];
    }
}
