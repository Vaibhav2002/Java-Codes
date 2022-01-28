package codechef;

import java.util.Scanner;

public class FiboPattern {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int a = 0, b = 1, c;
            if (k == 1)
                System.out.println(0);
            else if (k == 2) {
                System.out.println(0);
                System.out.println("1 1");
            } else {
                System.out.println(0);
                System.out.println("1 1");
                k -= 2;
                a = 1;
                b = 1;
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j <= i + 2; j++) {
                        c = a + b;
                        System.out.print(c + " ");
                        a = b;
                        b = c;
                    }
                    System.out.println();
                }
            }
        }
    }
}
