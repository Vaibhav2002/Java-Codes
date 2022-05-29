package codechef;

import java.util.Scanner;

public class InfinityStaircase {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[][] dp = new int[n+1][4];
        int ans = find(n, dp, 0);
        System.out.println(ans);
    }

    private static int find(int n, int[][] dp, int moved){
        if(n == 1) return 0;
        if(dp[n][moved]!=-1) return dp[n][moved];
        int ans = Integer.MAX_VALUE;
        if(moved != 1 && n-1>=1) ans = Math.min(ans, find(n-1, dp, 1));
        if(moved != 2 && n-2>=1) ans = Math.min(ans, find(n-2, dp, 2));
        if(moved != 3 && n-3>=1) ans = Math.min(ans, find(n-3, dp, 3));
        return dp[n][moved] = ans;
    }
}
