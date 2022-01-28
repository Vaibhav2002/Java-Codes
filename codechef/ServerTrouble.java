package codechef;

import java.util.Scanner;

public class ServerTrouble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextInt(), m = sc.nextInt();
            double dist = (double) n / (double) m;
            long ans = (long) Math.ceil(dist);
            long ans2 = n / ans;
            if (ans != Math.floor(dist))
                ans2 -= 1;
            System.out.println(ans + " " + ans2);
        }
    }
}
