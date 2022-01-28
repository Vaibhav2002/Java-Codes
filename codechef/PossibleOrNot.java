package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class PossibleOrNot {

    static boolean checkfreq(String s, String t) {
        int a[] = new int[2];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }
        return Arrays.equals(a, new int[]{0, 0});
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s1 = sc.next(), s2 = sc.next();
            if (checkfreq(s1, s2)) {
                int a[] = new int[2];
                int count = 0;
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        count++;
                        a[s2.charAt(i) - 'a']++;
                    }
                }
                if (count % 2 == 0 && a[0] == a[1]) {
                    System.out.println("Yes " + a[0]);
                } else
                    System.out.println("No");
            } else
                System.out.println("No");
        }
    }
}
