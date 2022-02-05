package leetcode;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        return find(m, n, dp);
    }

    public int find(int n, int m, int[][] dp) {
        if (n == 0 && m == 0) return 1;
        if (n == 1 || m == 1) return 1;
        if (n < 0 || m < 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];
        return dp[n][m] = (find(n - 1, m, dp) + find(n, m - 1, dp));
    }
}
