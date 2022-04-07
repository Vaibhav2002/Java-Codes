package DP;

import java.util.Arrays;

public class GoldMine {
    static int maxGold(int n, int m, int M[][]) {
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[M.length+1][M[0].length+1];
        for(int[] i:dp) Arrays.fill(i, -1);
        for (int i = 0; i < M.length; i++) {
            ans = Math.max(ans, find(i, 0, M, dp));
        }
        return ans;
    }

    static int find(int i, int j, int[][] a, int[][] dp) {
        if (i < 0 || i >= a.length || j >= a[0].length) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int topRight = find(i - 1, j + 1, a, dp);
        int right = find(i, j + 1, a, dp);
        int bottomRight = find(i + 1, j + 1, a, dp);
        int max = Math.max(topRight, Math.max(right, bottomRight));
        return dp[i][j] = a[i][j] + max;
    }
}
