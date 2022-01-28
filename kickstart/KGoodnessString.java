package kickstart;

import java.util.Scanner;

public class KGoodnessString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseno = 0;
        while (t-- > 0) {
            caseno++;
            int n = sc.nextInt(), k = sc.nextInt();
            String s = sc.next();
            char[] string = s.toCharArray();
            int good = 0, bad;
            for (int i = 0; i < n / 2; i++)
                if (string[i] != string[n - i - 1])
                    good++;
            bad = n - good;
            int ans = 0;
            if (good >= k)
                ans = good - k;
            else if (bad >= k - good)
                ans = k - good;
            System.out.println("Case #" + (caseno) + ": " + (ans));
        }
    }
}
