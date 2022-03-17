package leetcode;

import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows + 1][columns + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        return find(rows - 1, columns - 1, grid, dp);
    }

    private int find(int i, int j, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0) return -1;
        if (i == 0 && j == 0) return grid[0][0];
        if (dp[i][j] != -1) return dp[i][j];
        int top = find(i - 1, j, grid, dp);
        int left = find(i, j - 1, grid, dp);
        int ans = 0;
        if (top != -1 && left != -1)
            ans = Math.min(top, left);
        else if (top != -1) ans = top;
        else ans = left;
        ans += grid[i][j];
        return dp[i][j] = ans;
    }
}
