package codeJam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class EqualSum {

    private static class Pair{
        int n;
        long sum;
        Pair(int n, long sum){
            this.n = n;
            this.sum = sum;
        }
    }

    private static Scanner sc = new Scanner(System.in);

    private static void solve(int testCase) {
        int n = Integer.parseInt(sc.next());
        ArrayList<Long> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) a.add(2L *i-1);
        printNumbers(a);
        flush();
        readNumbers(a, n);
        var dp = new HashMap<Pair, ArrayList<Long>>();
        var subset = find(2 * n - 1, getSum(a) / 2, a, new ArrayList<>(), dp);
        printNumbers(subset);
        flush();
    }

    private static ArrayList<Long> find(int n, long sum, ArrayList<Long> num, ArrayList<Long> selected, HashMap<Pair, ArrayList<Long>> map) {
        if (n < 0 || sum == 0) return selected;
        if(map.containsKey(new Pair(n, sum))) return map.get(new Pair(n, sum));
        var taking = new ArrayList<Long>();
        var without = new ArrayList<Long>();
        if (num.get(n) <= sum) {
            selected.add(num.get(n));
            taking = find(n - 1, sum - num.get(n), num, new ArrayList<>(selected), map);
        }
        without = find(n - 1, sum, num, new ArrayList<>(selected), map);
        if (!taking.isEmpty()) {
            map.put(new Pair(n, sum), taking);
            return taking;
        }
        else {
            map.put(new Pair(n, sum), without);
            return without;
        }
    }

    private static void readNumbers(ArrayList<Long> a, int n) {
        for (int i = 0; i < n; i++)
            a.add(Long.parseLong(sc.next()));
    }

    private static void printNumbers(ArrayList<Long> a) {
        if(a.isEmpty()) {
            System.out.println(-1);
            return;
        }
        for (long i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    private static long getSum(ArrayList<Long> a) {
        long sum = 0;
        for (long i : a) sum += i;
        return sum;
    }

    private static void flush() {
        sc.nextLine();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++)
            solve(i);
    }
}
