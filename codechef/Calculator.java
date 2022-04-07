package codechef;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Calculator {

    static class Calc {
        int val1;
        int left;

        Calc(int val1, int left) {
            this.val1 = val1;
            this.left = left;
        }

        Calc incVal1() {
            return new Calc(val1 + 1, left - 1);
        }

        Calc incVal2(int b) {
            return new Calc(val1, left - b);
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt(), b = sc.nextInt();
        HashMap<Calc, Integer> dp = new HashMap<>();
        System.out.println(find(new Calc(0, n), 0, b, dp));
    }

    private static int find(Calc calc, int val2, int b, HashMap<Calc, Integer> dp) {
        if (calc.left == 0) return val2;
        if (dp.containsKey(calc)) return dp.get(calc);
        int btn1 = 0, btn2 = 0;
        if (calc.left >= 1) btn1 = find(calc.incVal1(), val2, b, dp);
        if (calc.left >= b) btn2 = find(calc.incVal2(b), val2 + calc.val1, b, dp);
        dp.put(calc, Math.max(btn1, btn2));
        return dp.get(calc);
    }
}
