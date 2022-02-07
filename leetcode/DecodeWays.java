package leetcode;

import java.util.Arrays;

public class DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        Arrays.fill(dp, -1);
        dp[len] = 1;
        dp[len - 1] = 1;
        return count(0, s.toCharArray(), dp);
    }

    public int count(int i, char[] s, int[] dp) {
        if (s[i] == '0') return 0;
        if (dp[i] != -1) return dp[i];
        int ans = count(i + 1, s, dp);
        if (Integer.parseInt(s[i] + "" + s[i + 1]) <= 26)
            ans += count(i + 2, s, dp);
        return dp[i] = ans;
    }
}
