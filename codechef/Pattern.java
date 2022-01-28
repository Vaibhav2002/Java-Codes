package codechef;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < 4; i++) {
                int val = (i == 2) ? 4 : (i == 3) ? 3 : i + 1;
                int startPow = (i != 2) ? 0 : 1;
                System.out.print(val + " ");
                for (int j = 0; j < n - 1; j++) {
                    val += 3 * (int) Math.pow(2, startPow++);
                    System.out.print(val + " ");
                }
                System.out.println();
            }

        }

    }
}
