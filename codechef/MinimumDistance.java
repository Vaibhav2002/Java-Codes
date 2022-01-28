package codechef;

import java.util.Scanner;

public class MinimumDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int min = Integer.MAX_VALUE;
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 1; i < n; i++) {
                min = Math.min(a[i] - a[i - 1], min);
            }
            System.out.println(min);
        }
    }
}
