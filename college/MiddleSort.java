package college;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MiddleSort {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solve();
    }

    static int getMiddleDigit(long n) {
        int len = getLength(n);
        for (int i = 0; i < len / 2; i++) {
            n /= 10;
        }
        return (int) n % 10;
    }

    private static int getLength(long n) {
        return (int) Math.log10(n) + 1;
    }

    private static void solve() {
        int n = sc.nextInt();
        ArrayList<Long> ar = new ArrayList<>();
        for (int i = 0; i < n; i++) ar.add(sc.nextLong());
        ar.sort((o1, o2) -> {
            int mid1 = getMiddleDigit(o1), mid2 = getMiddleDigit(o2);
            if (mid1 == mid2) return (int) (o1 - o2);
            return mid1 - mid2;
        });
        for (long i : ar) System.out.print(i + " ");
        System.out.println();
    }
}
