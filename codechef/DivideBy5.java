package codechef;

import java.util.Scanner;

public class DivideBy5 {


    static int find(long n) {
        while (n > 0) {
            long r = n % 10;
            if (r == 0 || r == 5)
                return 1;
            n /= 10;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(find(n));
        }
    }
}
