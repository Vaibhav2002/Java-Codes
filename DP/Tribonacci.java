package DP;

public class Tribonacci {

    public int tribonacci(int n) {
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
