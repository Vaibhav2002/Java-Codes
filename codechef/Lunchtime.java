package codechef;

import java.util.Scanner;

public class Lunchtime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long h[] = new long[n];
            for (int i = 0; i < n; i++)
                h[i] = sc.nextLong();
            long front[] = new long[n];
            long back[] = new long[n];
            for (int i = 0; i < n; i++) {
                if (i == 0)
                    front[i] = 0;
                else if (h[i] != h[i - 1])
                    front[i] = 0;
                else {
                    front[i] = front[i - 1] + 1;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (i == n - 1)
                    back[i] = 0;
                else if (h[i] != h[i + 1])
                    back[i] = 0;
                else {
                    back[i] = back[i + 1] + 1;
                }
            }

            for (int i = 0; i < n; i++)
                System.out.print(back[i] + front[i] + " ");
            System.out.println();
        }
    }
}
