package codechef;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class GameStart {

    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            HashMap<Integer, Integer> h1 = new HashMap<>(), h2 = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                h1.merge(x, 1, Integer::sum);
            }
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                h2.merge(x, 1, Integer::sum);
            }
            TreeSet<Integer> ans = new TreeSet<>();
            for (int i : h1.keySet()) {
                if (h1.get(i) == 1 && h2.getOrDefault(i, 0) == 1 && i % 3 == 0)
                    ans.add(i);
            }
            for (int i : ans)
                System.out.print(i + " ");
            System.out.println();

        }
    }
}
