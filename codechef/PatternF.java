package codechef;

import java.util.Scanner;

public class PatternF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            for (int i = k; i > 0; i--) {
                if (i % 2 == 0) {
                    for (int j = i; j > 0; j--)
                        System.out.print(j);
                } else {
                    for (int j = 1; j <= i; j++)
                        System.out.print(j);
                }
                System.out.println();
            }
        }
    }
}
