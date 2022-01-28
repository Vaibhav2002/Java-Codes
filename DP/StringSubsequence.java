package DP;

import java.util.Arrays;

public class StringSubsequence {
    int countWays(String S1, String S2) {
        int[][] dp = new int[S1.length() + 1][S2.length() + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        return count(0, 0, S1.toCharArray(), S2.toCharArray(), dp);
    }

    int count(int i, int j, char[] s, char[] t, int[][] dp) {
        if (i > s.length || j > t.length) return 0;
        if (j == t.length) return 1;
        if (i >= s.length) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s[i] != t[j]) return dp[i][j] = count(i + 1, j, s, t, dp);
        int taking = 1 + count(i + 1, j + 1, s, t, dp);
        int without = count(i + 1, j, s, t, dp);
        return dp[i][j] = taking + without;
    }
}
