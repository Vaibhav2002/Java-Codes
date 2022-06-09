package leetcode.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/">Problem</a>
 **/
public class FindKthLargestXORCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int r = matrix.length, c = matrix[0].length;
        int[] ans = new int[r*c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int top = 0, left = 0, topCorner = 0;
                if (i-1>=0 && j-1>=0) topCorner = matrix[i-1][j-1];
                if (i - 1 >= 0) top = matrix[i - 1][j];
                if (j - 1 >= 0) left = matrix[i][j - 1];
                matrix[i][j] = matrix[i][j] ^ top ^ left ^ topCorner;
                ans[index++] = matrix[i][j];
            }
        }
        Arrays.sort(ans);
        return ans[ans.length -k];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 2},
                {1, 6}
        };
        int k = 4;
        FindKthLargestXORCoordinateValue ob = new FindKthLargestXORCoordinateValue();
        System.out.println(ob.kthLargestValue(matrix, k));
    }
}
