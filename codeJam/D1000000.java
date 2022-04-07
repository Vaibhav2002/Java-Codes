package codeJam;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class D1000000 {
    private static Scanner sc = new Scanner(System.in);
    private static void solve(int testCase){
        int n = sc.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++)
            map.merge(sc.nextInt(), 1, Integer::sum);
        long count = 0;
        for(int i:map.keySet()){
            if(count<i) {
                int freq = map.get(i);
                if(count+freq<=i) count+=freq;
                else count+=i - count;
            }
        }
        System.out.println("Case #"+testCase+": "+count);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for(int i=1;i<=t;i++)
            solve(i);
    }
}
