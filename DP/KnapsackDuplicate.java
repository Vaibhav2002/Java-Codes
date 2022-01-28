package DP;

import java.util.Arrays;

public class KnapsackDuplicate {
    static int knapSack(int N, int W, int[] val, int[] wt) {
        int[][] dp = new int[N + 1][W + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        return solve(N, W, val, wt, dp);
    }

    static int solve(int n, int w, int val[], int[] wt, int dp[][]) {
        if (n == 0 || w == 0) return 0;
        if (dp[n][w] != -1) return dp[n][w];
        if (wt[n - 1] > w) return dp[n][w] = solve(n - 1, w, val, wt, dp);
        int taking = val[n - 1] + solve(n, w - wt[n - 1], val, wt, dp);
        int without = solve(n - 1, w, val, wt, dp);
        return dp[n][w] = Math.max(taking, without);
    }
}
