package codechef;

import java.util.Scanner;

public class NiceArray {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            a[i] = a[i] + max;
            max = Math.max(max, a[i]);
        }
        for (long i : a)
            System.out.print(i + " ");
    }
}
