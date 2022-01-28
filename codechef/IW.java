package codechef;

import java.util.Scanner;

public class IW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt(), y = sc.nextInt();
            if (x == y) {
                System.out.println(0);
                continue;
            }
            int count = 0;
            int max = Math.max(x, y), min = Math.min(x, y);
            int incmin = (min == x) ? x : y;
            int incmax = (max == x) ? x : y;
            while (min % max != 0) {
                count++;
                min += incmin;
            }
            while (max != min) {
                count++;
                max += incmax;
            }
            System.out.println(count);
        }
    }
}
