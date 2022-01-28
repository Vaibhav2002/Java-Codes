package DP;

import java.util.Arrays;

public class GeekAndItsGameOfCoins {

    public int findWinner(int N, int X, int Y) {
        int[] moves = new int[]{1, X, Y};
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        return find(N, moves, true, dp) ? 1 : 0;
    }

    public boolean find(int n, int[] moves, boolean isGeek, int[] dp) {
        if (dp[n] != -1) return dp[n] == 1;
        boolean canDo = false;
        for (int i : moves) {
            if (n - i >= 0)
                canDo |= find(n - i, moves, !isGeek, dp);
        }
        dp[n] = canDo ? 1 : 0;
        return canDo;
    }
}
