package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class ControlThePollution {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            int dp[] = new int[n + 1];
            Arrays.fill(dp, -1);
            int ans = solve(n, x, y, dp);
            System.out.println(ans);
        }
    }

    public static int solve(int n, int x, int y, int[] dp) {
        if (n <= 0) return 0;
        if (dp[n] != -1) return dp[n];
        int bus = x + solve(n - 100, x, y, dp);
        int car = y + solve(n - 4, x, y, dp);
        return dp[n] = Math.min(bus, car);
    }
}
