package codechef;

import java.util.Scanner;

public class BeautifulGarland {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String s = sc.next();
        s += s.charAt(0);
        char c[] = s.toCharArray();
        int pairs = 0, cG = 0, cR = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == c[i + 1]) {
                if (pairs == 2 || cG > 1 || cR > 1) break;
                if (c[i] == 'R') cR++;
                else cG++;
                pairs++;
            }
        }
        boolean isPossible = pairs == 0 || (pairs == 2 && cG == 1 && cR == 1);
        System.out.println(isPossible ? "YES" : "NO");
    }
}
