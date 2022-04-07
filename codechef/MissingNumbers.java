package codechef;

import java.util.ArrayList;
import java.util.Scanner;

public class MissingNumbers {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < 4; i++) values.add(sc.nextInt());
        int min = getMin(values), max = getMax(values);
        values.remove(Integer.valueOf(min));
        values.remove(Integer.valueOf(max));
        int sub, add;
        if (min < 0)
            sub = min;
        else
            sub = Math.min(values.get(0), values.get(1));
        add = Math.max(values.get(0), values.get(1));
        if ((add + sub) % 2 != 0) {
            System.out.println("-1 -1");
            return;
        }
        int a = (add + sub) / 2;
        int b = add - a;
        System.out.println(a + " " + b);
    }

    private static int getMax(ArrayList<Integer> a) {
        int max = Integer.MIN_VALUE;
        for (int i : a) max = Math.max(i, max);
        return max;
    }

    private static int getMin(ArrayList<Integer> a) {
        int min = Integer.MAX_VALUE;
        for (int i : a) min = Math.min(i, min);
        return min;
    }
}
