package college;

import java.util.Arrays;
import java.util.Scanner;

public class RealEstateShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextLong();
            Arrays.sort(a);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (k < a[i]) break;
                k -= a[i];
                count++;
            }
            System.out.println(count);
        }
    }
}
