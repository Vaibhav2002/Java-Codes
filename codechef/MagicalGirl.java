package codechef;

import java.util.Scanner;

public class MagicalGirl {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int r = sc.nextInt(), g = sc.nextInt(), b = sc.nextInt(), m = sc.nextInt();
        int rMax = 0, gMax = 0, bMax = 0;
        for (int i = 0; i < r; i++) rMax = Math.max(rMax, sc.nextInt());
        for (int i = 0; i < g; i++) gMax = Math.max(gMax, sc.nextInt());
        for (int i = 0; i < b; i++) bMax = Math.max(bMax, sc.nextInt());
        for (int i = 0; i < m; i++) {
            int min = Math.min(rMax, Math.min(gMax, bMax));
            if (min == rMax) rMax /= 2;
            else if (min == gMax) gMax /= 2;
            else bMax /= 2;
        }
        System.out.println(Math.max(rMax, Math.max(gMax, bMax)));
    }
}
