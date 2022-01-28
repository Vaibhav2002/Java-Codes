package codechef;

import java.util.Scanner;

public class BellaCiao {

    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long D = sc.nextLong(), d = sc.nextLong(), p = sc.nextLong(), q = sc.nextLong();
            long n = D / d;
            long ans = n * (2 * p + (n - 1) * q) / 2 *d;
            ans += D % d * (p + n*q);
            System.out.println(ans);
        }
    }
}
