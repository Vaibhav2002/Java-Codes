package college;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CodeplayQ2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                map.merge(a[i], 1, Integer::sum);
            }
            for (int i = 0; i < n; i++) {
                int freq = map.get(a[i]);
                map.put(a[i], freq - 1);
                a[i] = a[i] * freq;
            }
            for (long i : a) System.out.print(i + " ");
            System.out.println();
        }
    }
}
