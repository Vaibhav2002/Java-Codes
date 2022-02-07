package leetcode;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        return solve(amount, 0, coins);
    }

    private int solve(int left, int index, int[] coins) {
        if (index >= coins.length) return 0;
        if (left < 0) return 0;
        if (left == 0) return 1;
        int taking = 1 + solve(left - coins[index], index, coins);
        int without = solve(left, index + 1, coins);
        if (taking != 0 && without != 0)
            return Math.min(taking, without);
        else if (taking != -1) return taking;
        else return without;
    }
}
