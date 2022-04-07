package DP;

import java.util.Arrays;

public class MinJumps {
    static int minJumps(int[] arr) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, -2);
        return calc(0, arr, dp);
    }

    static int calc(int i, int[] arr, int[] dp) {
        if (i >= arr.length-1) return 0;
        if (arr[i] == 0) return -1;
        if (dp[i] != -2) return dp[i];
        int min = Integer.MAX_VALUE;
        boolean anyNotValid = false;
        for (int j = 1; j <= arr[i]; j++) {
            int val = calc(j + i, arr, dp);
            if (val == -1) anyNotValid = true;
            else min = Math.min(val, min);
        }
        return dp[i] = (min == Integer.MAX_VALUE && anyNotValid) ? -1 : min+1;
    }
}
