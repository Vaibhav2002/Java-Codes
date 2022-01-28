package codechef;

import java.util.Scanner;

public class FlappyBird {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long h = sc.nextLong();
            int[] indexes = new int[n];
            long[] heights = new long[n];
            boolean win = true;
            for (int i = 0; i < n; i++)
                indexes[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                heights[i] = sc.nextLong();
            for (int i = 0; i < n; i++) {
                if (i == 0)
                    h += indexes[i];
                else
                    h += indexes[i] - indexes[i - 1];
                if (h <= heights[i]) {
                    win = false;
                    break;
                }
            }
            System.out.println(win ? "YES" : "NO");
        }
    }
}
