package leetcode;

public class PerfectSquare {
    public int numSquares(int n) {
        return solve(1, n);
    }

    private int solve(int n, int target) {
        if (target - n < 0) return 0;
        if (target == n) return 1;
        int taking = 1 + solve(n, target - n);
        int without = solve((n + 1) * (n + 1), target);
        if (taking != 0 && without != 0)
            return Math.min(taking, without);
        else if (taking != 0) return taking;
        else return without;
    }
}
