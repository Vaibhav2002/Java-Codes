package HACKERRANK;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SubarrayQueries {
    public static List<Long> findSum(List<Integer> numbers, List<List<Integer>> queries) {
        List<Long> ans = new ArrayList<>();
        List<Long> zeroSum = new ArrayList<>();
        List<Long> prefixSum = new ArrayList<>();
        long sum = 0,zero_sum=0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 0)
                zero_sum++;
            zeroSum.add(zero_sum);
            sum += numbers.get(i);
            prefixSum.add(sum);
        }
        for (List<Integer> i : queries) {
            int l = i.get(0)-1, r = i.get(1)-1, x = i.get(2);
            long sumRange = prefixSum.get(r) - prefixSum.get(l) + numbers.get(l);
            long countZero = zeroSum.get(r)-zeroSum.get(l)+((numbers.get(l)==0)?1:0);
            sumRange += countZero * x;
            ans.add(sumRange);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    }
}
