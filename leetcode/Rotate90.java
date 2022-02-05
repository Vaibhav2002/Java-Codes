package leetcode;

public class Rotate90 {
    public int[] getVal(int i, int j, int rows, int column) {
        int modifiedColumn = column - i - 1;
        int modifiedRow = j;
        return new int[]{modifiedRow, modifiedColumn};
    }

    public void rotate(int[][] matrix) {
        int row = matrix[0].length, column = matrix.length;
        for(int i=0;i<row; i++){
            for(int j = 0;j<column; j++){
                int newIndex[] = getVal(i, j, row, column);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[newIndex[0]][newIndex[1]];
                matrix[newIndex[0]][newIndex[1]] = temp;
            }
        }
    }
}
