package codechef;

import java.util.Scanner;

public class PointOfImpact {

    static class Points {
        long x, y;

        Points(long x1, long y1) {
            x = x1;
            y = y1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            long n = sc.nextLong(), k = sc.nextLong();
            long x = sc.nextLong(), y = sc.nextLong();
            if (x == y) {
                System.out.println(n + " " + n);
            } else {
                Points[] points = new Points[4];
                long xt, yt;
                if (x > y) {
                    xt = n;
                    yt = xt - x + y;
                } else {
                    yt = n;
                    xt = yt - y + x;
                }
                points[0] = new Points(xt, yt);
                x = xt;
                y = yt;
                if (x == n) {
                    yt = n;
                    xt = -(yt - y - x);
                } else {
                    xt = n;
                    yt = -xt + x + y;
                }
                points[1] = new Points(xt, yt);
                x = xt;
                y = yt;
                if (y == n) {
                    xt = 0;
                    yt = xt + y - x;
                } else {
                    yt = 0;
                    xt = yt - y + x;
                }
                points[2] = new Points(xt, yt);
                x = xt;
                y = yt;
                if (x == 0) {
                    yt = 0;
                    xt = -(yt - y - x);
                } else {
                    xt = 0;
                    yt = -xt + x + y;
                }
                points[3] = new Points(xt, yt);
                k--;
                Points ans = points[(int) (k % 4)];
                System.out.println(ans.x + " " + ans.y);
            }
        }

    }
}

