package codechef;

import java.util.Scanner;

public class PatternD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println(i);
            }
        }
    }
}
