package codechef;

import java.util.Scanner;

public class OO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long c = 0;
            while (n > 0) {
                c++;
                n &= (n - 1);
            }
            System.out.println(c);
        }
    }
}
