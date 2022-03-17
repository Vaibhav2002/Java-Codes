package HACKERRANK;

import java.util.Scanner;

public class StringAbbreviation {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String s = sc.nextLine(), t = sc.nextLine();
        System.out.println(abbreviation(s, t));
    }

    public static String abbreviation(String a, String b) {
        char[] c = a.toCharArray(), d = b.toCharArray();
        int i = 0, j = 0;
        while (i < c.length && j < d.length) {
            if (c[i] != d[j] && c[i] - 32 != d[j]) i++;
            else {
                i++;
                j++;
            }
        }
        boolean arrAllLeftSmall = true;
        for (int k = i; k < c.length; k++) {
            if (Character.isUpperCase(c[k])) {
                arrAllLeftSmall = false;
                break;
            }
        }
        return (j == d.length && arrAllLeftSmall) ? "YES" : "NO";
    }
}
