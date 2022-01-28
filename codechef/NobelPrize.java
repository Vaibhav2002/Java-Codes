package codechef;

import java.util.Scanner;

public class NobelPrize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            boolean isFree[] = new boolean[m];
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                isFree[x - 1] = true;
            }
            boolean canWin = false;
            for (boolean f : isFree) {
                if (!f) {
                    canWin = true;
                    break;
                }
            }
            System.out.println(canWin ? "Yes" : "No");
        }
    }
}
