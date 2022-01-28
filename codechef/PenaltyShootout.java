package codechef;

import java.util.Scanner;

public class PenaltyShootout {
    public static void main(String[] arge) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int team1 = 0, team2 = 0;
            boolean done = true;
            for (int i = 0; i < 2 * n; i++) {

                if (i % 2 == 0) {
                    if (s.charAt(i) == '1')
                        team1++;
                } else {
                    if (s.charAt(i) == '1')
                        team2++;
                }
                if (Math.abs(team1 - team2) > (int)Math.ceil((double) (2 * n - i)/2)) {
                    System.out.println(i);
                    done = false;
                    break;
                }
            }
            if (done)
                System.out.println(2*n);
        }
    }
}
