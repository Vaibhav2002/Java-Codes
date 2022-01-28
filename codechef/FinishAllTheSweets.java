package codechef;

import java.util.HashMap;
import java.util.Scanner;

public class FinishAllTheSweets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            Integer freq = hash.get(x);
            hash.put(x, freq == null ? 1 : freq + 1);
        }
        int ans = 0;
        for (int i : hash.keySet()) {
            int freq = hash.get(i);
            ans += (int) (Math.ceil((double) freq / 2));
        }
        System.out.println(ans);
    }
}
