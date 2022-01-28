package codechef;

import java.util.Scanner;

public class DaanishandProblems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            long a[] = new long[10];
            for (int i = 0; i < 10; i++)
                a[i] = sc.nextLong();
            long k = sc.nextLong();
            for (int i = 9; i >= 0; i--) {
                if (k < a[i])
                    break;
                if (k == a[i]) {
                    a[i] = 0;
                    k = 0;
                } else {
                    k -= a[i];
                    a[i] = 0;
                }

            }
            int max = 0;
            for (int i = 0; i < 10; i++)
                if (a[i] != 0)
                    max = i;
            System.out.println(max + 1);
        }
    }
}
