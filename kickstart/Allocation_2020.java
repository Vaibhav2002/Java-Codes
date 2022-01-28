package kickstart;

import java.util.Arrays;
import java.util.Scanner;

public class Allocation_2020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int b = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int count = 0;
            for (int i : a) {
                if (i <= b) {
                    count++;
                    b -= i;
                }
            }
            System.out.println("Case #" + (t + 1) + ": " + count);
        }
    }
}
