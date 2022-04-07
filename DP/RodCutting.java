package DP;

import java.util.Arrays;

public class RodCutting {
    public int cutRod(int price[], int n) {
        int[][] dp = new int[price.length+1][n+1];
        for(int[] i:dp) Arrays.fill(i, -1);
        return find(price.length, n, price, dp);
    }

    private int find(int i, int left, int[] prices, int[][] dp) {
        if (i <= 0 || left == 0) return 0;
        int ans = 0;
        if(dp[i-1][left] !=-1) return dp[i-1][left];
        if (left - i >= 0)
            ans = prices[i - 1] + find(i, left - i, prices, dp);
        ans = Math.max(ans, find(i - 1, left, prices, dp));
        return dp[i-1][left] = ans;
    }
}
