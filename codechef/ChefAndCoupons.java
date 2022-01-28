package codechef;

import java.util.Scanner;

public class ChefAndCoupons {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        while (t-- > 0) {
            long d = sc.nextLong(), c = sc.nextLong();
            long sumA = 0, sumB = 0;
            for (int i = 0; i < 3; i++)
                sumA += sc.nextLong();
            for (int i = 0; i < 3; i++)
                sumB += sc.nextLong();
            long total_without_coupon = sumA + sumB + 2 * d;
            long total_with_coupon = sumA + sumB + c;
            if (sumA < 150)
                total_with_coupon += d;
            if (sumB < 150)
                total_with_coupon += d;
            System.out.println(total_with_coupon < total_without_coupon ? "YES" : "NO");
        }
    }
}
