package codechef;

import java.util.Scanner;

public class PatternB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int a[][] = new int[k][k];
            for (int i = 0; i < k; i++) {
                a[i][i] = i+1;
                a[i][k - i - 1] = i+1;
            }
            for (int i[] : a) {
                for (int j : i) {
                    if (j!=0)
                        System.out.print(j);
                    else
                        System.out.print(" ");

                }
                System.out.println();
            }
        }
    }
}
