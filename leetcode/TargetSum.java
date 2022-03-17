package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TargetSum {
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length + 1][2 * total + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        return find(0, 0, target, nums, dp);
    }

    private int find(int i, int sum, int target, int[] nums, int[][] dp) {
        if (i == nums.length) return sum == target ? 1 : 0;
        if (dp[i][sum + total] != -1) return dp[i][sum + total];
        int add = find(i + 1, sum + nums[i], target, nums, dp);
        int sub = find(i + 1, sum - nums[i], target, nums, dp);
        return dp[i][sum + total] = add + sub;
    }
}
