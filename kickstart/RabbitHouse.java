package kickstart;

import java.util.Scanner;

public class RabbitHouse {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseno = 0;
        while (t-- > 0) {
            caseno++;
            int r = sc.nextInt(), c = sc.nextInt();
            int a[][] = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            count(a, 0, 0, r, c);
            System.out.println("Case #" + (caseno) + ": " + ans);
            ans = 0;
        }
    }

    public static void count(int a[][], int i, int j, int r, int c) {
        if (i == r - 1 && j == c - 1)
            return;
        if (i == r - 1) {
            int diff = Math.abs(a[i][j] - a[i][j + 1]) - 1;
            if (diff < 0)
                diff = 0;
            if (a[i][j] > a[i][j + 1])
                a[i][j + 1] += diff;
            else if (a[i][j + 1] > a[i][j])
                a[i][j] += diff;
            ans += diff;
            count(a, i, j + 1, r, c);
        } else if (j == c - 1) {
            int diff = Math.abs(a[i][j] - a[i + 1][j]) - 1;
            if (diff < 0)
                diff = 0;
            if (a[i][j] > a[i + 1][j])
                a[i + 1][j] += diff;
            else if (a[i][j] < a[i + 1][j])
                a[i][j] += diff;
            ans += diff;
            count(a, i + 1, j, r, c);
        } else {
            int diff = Math.abs(a[i][j] - a[i][j + 1]) - 1;
            if (diff < 0)
                diff = 0;
            if (a[i][j] > a[i][j + 1])
                a[i][j + 1] += diff;
            else if (a[i][j + 1] > a[i][j])
                a[i][j] += diff;
            ans += diff;
            diff = Math.abs(a[i][j] - a[i + 1][j]) - 1;
            if (diff < 0)
                diff = 0;
            if (a[i][j] > a[i + 1][j])
                a[i + 1][j] += diff;
            else if (a[i][j] < a[i + 1][j])
                a[i][j] += diff;
            ans += diff;
            count(a, i + 1, j, r, c);
            count(a, i, j + 1, r, c);
        }


    }
}

