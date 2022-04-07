package DP.leetcode;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        int from0 = find(0, nums.length-1, nums, dp);
        Arrays.fill(dp, -1);
        int from1 = find(1, nums.length, nums, dp);
        return Math.max(from1, from0);
    }

    private int find(int i, int end, int [] nums, int[] dp){
        if(i >= end) return 0;
        if(dp[i] !=-1) return dp[i];
        int taking = nums[i] + find(i+2, end, nums, dp);
        int without = find(i+1, end, nums, dp);
        return dp[i] = Math.max(taking, without);
    }
}
