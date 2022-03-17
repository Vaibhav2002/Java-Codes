package college;

import java.util.HashMap;
import java.util.Scanner;

public class GDSCCP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        var map = new HashMap<Integer, Integer>();
        int maxFreq = 0;
        for (int i : a) {
            map.merge(i, 1, Integer::sum);
            maxFreq = Math.max(maxFreq, map.get(i));
        }
        System.out.println(n - maxFreq);
    }
}
