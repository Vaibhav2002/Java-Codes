package codechef;

import java.util.Scanner;

public class F_C {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int a[][] = new int[k * 2 - 1][k * 2 - 1];
            for (int i = 0; i < k - 1; i++) {
                for (int j = i; j < a[0].length - i; j++) {
                    a[i][j] = i+1;
                }
            }
            a[k - 1][k - 1] = k;
            for (int i = k - 2; i >= 0; i--) {
                for (int j = i; j < a[0].length - i; j++) {
                    a[a.length - i - 1][j] = 2*k-i-1;
                }
            }
            for (int[] i : a) {
                for (int j : i) {
                    System.out.print(j == 0 ? " " : j);
                }
                System.out.println();
            }

        }
    }
}
