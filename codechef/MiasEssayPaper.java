package codechef;

import java.util.Scanner;

public class MiasEssayPaper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            String s = sc.next();
            long ans = 0;
            char[] a = s.toCharArray();
            for (int i = 0; i < a.length / 2; i++) {
                ans += Math.abs(a[i] - a[a.length - i - 1]);
            }
            System.out.println(ans);
        }
    }


}
