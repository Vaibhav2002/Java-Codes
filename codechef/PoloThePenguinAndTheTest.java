package codechef;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class PoloThePenguinAndTheTest {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt(), w = sc.nextInt();
        int[] tests = new int[n], points = new int[n], time = new int[n];
        int[][] dp = new int[n+1][w+1];
        for(int[] i:dp) Arrays.fill(i, -1);
        for (int i = 0; i < n; i++) {
            tests[i] = sc.nextInt();
            points[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        int ans = calc(w, 0, tests, points, time, dp);
        System.out.println(ans);

    }

    private static int calc(int left, int index, int[] tests, int[] points, int[] time, int[][] dp) {
        if (left == 0) return 0;
        if(dp[index][left]!=-1) return dp[index][left];
        int ans = 0;
        if (index < tests.length) {
            if (left >= time[index]) {
                int currQuestionPoints = tests[index] * points[index];
                ans = currQuestionPoints + calc(left - time[index], index + 1, tests, points, time, dp);
            }
            ans = Math.max(ans, calc(left, index + 1, tests, points, time, dp));
        }
        return dp[index][left] = ans;

    }
}
