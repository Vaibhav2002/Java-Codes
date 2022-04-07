package college;

import java.util.HashSet;
import java.util.Scanner;

public class SubstringSum {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt(), x = sc.nextInt();
        String s = sc.next();
        boolean found = check(s.toCharArray(), x);
        System.out.println(found ? 1 : -1);

    }

    static boolean isValidSubstring(char s[], int target) {
        HashSet<Character> hash = new HashSet<>();
        int sum = 0;
        for (char c : s) {
            if (hash.contains(c)) return false;
            sum += c - 96;
            hash.add(c);
        }
        return sum == target;
    }


    static boolean check(char s[], int target) {
        for (int i = 1; i <= s.length; i++) {
            for (int j = 0; j <= s.length - i; j++) {
                int len = j + i - 1;
                StringBuilder sb = new StringBuilder();
                for (int k = j; k <= len; k++) {
                    sb.append(s[k]);
                }
                if (isValidSubstring(sb.toString().toCharArray(), target)) return true;
            }
        }
        return false;
    }
}
