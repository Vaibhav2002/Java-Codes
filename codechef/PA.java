package codechef;

import java.util.Scanner;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int[][] a = new int[k][k];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    a[i][i] = 1;
                    a[i][k - i - 1] = 1;
                    if (i == 0 || i == k - 1 || j == 0 || j == k - 1)
                        a[i][j] = 1;
                }
            }
            for (int[] i : a) {
                for (int j : i)
                    System.out.print((j == 0) ? " " : "1");
                System.out.println();
            }
        }
    }
}
