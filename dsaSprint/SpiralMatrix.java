package dsaSprint;

import java.util.ArrayList;
import java.util.Scanner;

public class SpiralMatrix {

    static ArrayList<Integer> spirallyTraverse(int[][] matrix, int r, int c) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (c == 1) {
            for (int i = 0; i < r; i++)
                ans.add(matrix[i][0]);
            return ans;
        }
        for (int i = 0; i < r / 2; i++) {
            for (int j = i; j < c - i; j++)
                ans.add(matrix[i][j]);
            for (int j = i + 1; j < r - i; j++)
                if (c - i - 1 >= 0)
                    ans.add(matrix[j][c - i - 1]);
            for (int j = c - i - 2; j >= i; j--)
                if (r - i - 1 >= 0)
                    ans.add(matrix[r - i - 1][j]);
            for (int j = r - i - 2; j > i; j--)
                ans.add(matrix[j][i]);
        }
        if (r % 2 == 1) {
            for (int i = r / 2; i < c - r / 2; i++)
                ans.add(matrix[r / 2][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int matrix[][] = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                matrix[i][j] = sc.nextInt();

        ArrayList<Integer> spiral = spirallyTraverse(matrix, r, c);
        System.out.println(spiral.toString());
    }


}
