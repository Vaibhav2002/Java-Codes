package leetcode;

import java.util.Arrays;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return find(0, nums, dp);
    }

    public boolean find(int n, int[] nums, int[] dp) {
        if (n >= nums.length - 1) return true;
        if (nums[n] == 0) return false;
        if (dp[n] != -1) return dp[n] == 1;
        for (int i = 1; i <= nums[n]; i++) {
            if (n + i < nums.length) {
                if (find(n + i, nums, dp)) return true;
            }
        }
        dp[n] = 0;
        return false;
    }
}
