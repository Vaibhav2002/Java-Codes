package codechef;

import java.util.Scanner;

public class GoldCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] values = new int[n];
            for (int i = 0; i < n; i++)
                values[i] = sc.nextInt();
            int q = sc.nextInt();
            int sum = 0;
            int[] prefix = new int[n];
            for (int i = 0; i < n; i++) {
                sum += values[i];
                prefix[i] = sum;
            }
            while (q-- > 0) {
                int l = sc.nextInt(), r = sc.nextInt();
                long ans = prefix[r - 1] - prefix[l - 1] + values[l - 1];
                System.out.println(ans);
            }
        }

    }
}
