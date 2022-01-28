package arraycodes;

import java.util.HashMap;
import java.util.Scanner;

public class RearrangeWithRespectToIndex {
    void prank(long[] a, int n) {
        for(int i = 0;i<n;i++){
            a[i] = a[i] + (a[(int )a[i]]% (long) n) * (long) n;
        }
        for(int i = 0;i<n;i++)
            a[i] = a[i]/ (long) n;
        for (long i : a)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        RearrangeWithRespectToIndex ob = new RearrangeWithRespectToIndex();
        ob.prank(a, n);
    }
}
