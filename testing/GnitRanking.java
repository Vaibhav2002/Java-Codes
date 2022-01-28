package testing;

import java.util.Arrays;
import java.util.Scanner;

public class GnitRanking {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long mark = sc.nextLong();
        long l[] = new long[n];
        for (int i = 0; i < n; i++)
            l[i] = sc.nextLong();
        Arrays.sort(l);
        boolean isPresent = false;
        for (int i = 1; i <= 10; i++) {
            long m = l[n - i];
            if (m == mark) {
                isPresent = true;
                break;
            }
        }
        System.out.println(isPresent ? "Happy" : "Not Happy");

    }
}
