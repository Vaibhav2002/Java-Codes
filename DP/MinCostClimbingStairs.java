package DP;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2)
            return Math.min(cost[0], cost[1]);
        int dp[] = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        int from1 = getMinCost(cost, 0, dp);
        int from2 = getMinCost(cost,1,dp);
        return Math.min(from1, from2);
    }

    public int getMinCost(int[] cost, int index, int[] dp) {
        if (index >= cost.length) return 0;
        if (dp[index] != 1) return dp[index];
        int currentCost = cost[index];
        int step1 = getMinCost(cost, index + 1, dp);
        int step2 = getMinCost(cost, index + 2, dp);
        dp[index] = currentCost + Math.min(step1, step2);
        return dp[index];
    }
}
