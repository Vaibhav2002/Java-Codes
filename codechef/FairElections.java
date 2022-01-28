package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class FairElections {

    static long findSwaps(Long a[], Long b[], long sumA, long sumB) {
        Arrays.sort(a);
        Arrays.sort(b, (o1, o2) -> -1 * o1.compareTo(o2));
        if (sumA > sumB)
            return 0;
        int i = 0, j = 0;
        long count = 0;
        while (sumA <= sumB && i < a.length && j < b.length) {
            if (a[i] < b[i]) {
                sumA += b[i] - a[i];
                sumB -= b[i] - a[i];
                i++;
                count++;
            }
            j++;
        }
        if (sumA > sumB) return count;
        return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            Long[] a = new Long[n];
            Long[] b = new Long[m];
            long sumA = 0, sumB = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                sumA += a[i];
            }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextLong();
                sumB += b[i];
            }
            System.out.println(findSwaps(a, b, sumA, sumB));
        }
    }
}
