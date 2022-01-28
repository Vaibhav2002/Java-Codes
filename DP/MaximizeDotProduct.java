package DP;

import java.util.Arrays;

public class MaximizeDotProduct {
    public int maxDotProduct(int n, int m, int a[], int b[]) {
        int[][] dp = new int[n+1][m+1];
        for(int[] i:dp) Arrays.fill(i, -1);
        return find(n - 1, m - 1, a, b, dp);
    }

    public int find(int n, int m, int a[], int b[], int[][] dp) {
        if (n < 0 || m < 0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        int with0 = find(n - 1, m, a, b, dp);
        int without = a[n] * b[m] + find(n - 1, m - 1, a, b, dp);
        return Math.max(with0, without);
    }

    public static void main(String[] args) {
        MaximizeDotProduct ob = new MaximizeDotProduct();
        int[] a = {17, 2};
        int[] b = {6, 7};
        System.out.println(ob.maxDotProduct(2, 2, a, b));
    }
}
