package codechef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class BasketStart {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ArrayList<Integer> ans = new ArrayList<>();
            HashSet<Integer> hash = new HashSet<>();
            int n = sc.nextInt(), m = sc.nextInt();
            for (int i = 0; i < n; i++)
                hash.add(sc.nextInt());
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                if (hash.contains(x))
                    ans.add(x);
            }
            Collections.sort(ans);
            for (int i : ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
