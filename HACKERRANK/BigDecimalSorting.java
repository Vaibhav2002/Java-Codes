package HACKERRANK;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigDecimalSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s[] = new String[n];
        for (int i = 0; i < n; i++)
            s[i] = sc.next();
        Arrays.sort(s, (o1, o2) -> {
            BigDecimal a = new BigDecimal(o1), b = new BigDecimal(o2);
            return -1 * a.compareTo(b);
        });
        System.out.println(Arrays.toString(s));

    }
}
