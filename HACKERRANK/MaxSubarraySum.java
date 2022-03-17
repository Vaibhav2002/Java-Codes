package HACKERRANK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxSubarraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        int index = 0;
        for (String s : br.readLine().split(" ")) {
            a[index++] = Integer.parseInt(s);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(find(n - 1, a, dp));
    }

    public static int find(int n, int[] a, int[] dp) {
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        return dp[n] = Math.max(a[n] + find(n - 2, a, dp), find(n - 1, a, dp));
    }
}
