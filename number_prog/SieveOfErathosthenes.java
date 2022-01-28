package number_prog;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfErathosthenes {


    //sieve of erathosthenes , this algorithm prints prime numbers till n in O ( n log log n )
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * 2; j <= n; j += i)
                    primes[j] = false;
            }
        }
        for (int i = 2; i < n; i++) {
            if (primes[i])
                System.out.print(i + " ");
        }
    }
}
