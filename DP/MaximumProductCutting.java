package DP;

import java.util.Arrays;

public class MaximumProductCutting {
    public int maxProduct(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return find(n, dp);
    }

    public int find(int n, int[] dp) {
        if (n <= 2) return 1;
        if (dp[n] != -1) return dp[n];
        int leftNum = n / 2;
        int rightNum = n / 2 + ((n % 2 == 0) ? 0 : 1);
        int left = Math.max(leftNum, find(leftNum, dp));
        int right = Math.max(rightNum, find(rightNum, dp));
        return dp[n] = left * right;
    }
}
