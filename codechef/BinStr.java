package codechef;

import java.util.*;
import java.lang.*;

class BinStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] x = sc.nextLine().split(" ");
            int n = Integer.parseInt(x[0]), k = Integer.parseInt(x[1]);
            String s = sc.nextLine();
            int count = 0;
            for (int i = 0; i < n / 2; i++) {
                if (s.charAt(i) != s.charAt(n - i - 1)) count++;
                if (count > k) break;
            }
            boolean isPossible = k == count || count == 0;
            System.out.println(isPossible ? "YES" : "NO");
        }
    }
}