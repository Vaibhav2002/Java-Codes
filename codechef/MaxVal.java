package codechef;

import java.util.Scanner;

public class MaxVal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long min, min2, max1, max2;
            min = max1 = x;
            min2 = max2 = sc.nextLong();
            for (int i = 2; i < n; i++) {
                long y = sc.nextLong();
                if (y <= min) {
                    min2 = min;
                    min = y;
                } else if (y < min2) {
                    min2 = y;
                }
                if (y >= max1) {
                    max2 = max1;
                    max1 = y;
                } else if (y > max2)
                    max2 = y;
            }
            long ans = Math.max((min * min2 + min2 - min), (max1 * max2 + max1 - max2));
            System.out.println(ans);
        }
    }
}
