package HACKERRANK;

import java.util.HashMap;
import java.util.Scanner;

public class DivSumPair {
    static int divisibleSumPairs(int n, int k, int[] ar) {
        HashMap<Integer, Integer> ob = new HashMap<>();
        int c = 0;
        for (int i : ar) {
            if (ob.containsKey(k-(i%k))) {
                c += ob.get(k-(i%k));
            }
            if (ob.containsKey(i))
                ob.put(i, ob.get(i) + 1);
            else
                ob.put(i, 1);
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(divisibleSumPairs(n,k,a));
    }
}
