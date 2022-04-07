package college;

import java.util.Scanner;

public class TrickyTraingle {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; n > 0; i++) {
            if (n - i < 0) break;
            n -= i;
            count++;
        }
        System.out.println(count);
    }
}
