package DP;

public class SumOfAllDigits1toN {
    static int sumOfDigits(int n) {
        int ans = 0;
        int[] dp = new int[n + 1];
        for (int i = n; i > 0; i--)
            ans += calc(i, dp);
        return ans;
    }

    static int findLength(int n) {
        return (int) Math.log(n) + 1;
    }

    static int calc(int n, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        return dp[n] = calc(n / (int) Math.pow(10, findLength(n)), dp);
    }
}
