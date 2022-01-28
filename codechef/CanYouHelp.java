package codechef;

import java.util.Scanner;

public class CanYouHelp {

    static long factorial(long n) {
        long f = 1;
        for (long i = 2; i <= n; i++)
            f *= i;
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong(), x = sc.nextLong();
            long odd = n / 2, even = n - odd;
            long amount = (factorial(odd) / (2 * factorial(odd - 2))) + (factorial(even) / (2 * factorial(even - 2)));
            amount *= 2;
            String s = (amount > x) ? "Profit" : (amount < x) ? "Loss" : "Null";
            System.out.println((Math.abs(x - amount)) + " " + s);


        }
    }
}
