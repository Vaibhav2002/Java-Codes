package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class count {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            a[i] = num;
        }
        HashMap<Integer, Integer> ob = new HashMap<>();
        int count = 0, max = 0;
        for (int i = 0; i < m; i++) {
            if (ob.containsKey(a[i]))
                ob.put(a[i], ob.get(a[i]) + 1);
            else {
                ob.put(a[i], 1);
                count++;
            }
        }
        max = count;
        for (int i = m; i < a.length; i++) {
            if (ob.get(a[i - m]) > 1) {
                ob.put(a[i - m], ob.get(a[i - m]) - 1);
            } else {
                ob.remove(a[i - m]);
                count--;
            }
            if (ob.containsKey(a[i])) {
                ob.put(a[i], ob.get(a[i]) + 1);
            } else {
                ob.put(a[i], 1);
                count++;
            }
            if (count > max)
                max = count;

        }
        System.out.println(max);
    }
}
