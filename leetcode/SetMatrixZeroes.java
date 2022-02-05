package leetcode;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, column = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = -1;
                    matrix[i][0] = -1;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[0][j] == -1 || matrix[i][0] == -1)
                    matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        SetMatrixZeroes ob = new SetMatrixZeroes();
        ob.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
