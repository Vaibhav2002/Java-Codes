package leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums/">Problem</a>
 **/
public class FindKPairsWithSmallestSums {

//    private static class Pair implements Comparable<Pair>{
//        int a, b;
//
//        public Pair(int a, int b) {
//            this.a = a;
//            this.b = b;
//        }
//        public int sum(){
//            return a+b;
//        }
//
//        @Override
//        public int compareTo(Pair o) {
//            return Integer.compare(o.sum(), sum());
//        }
//    }
//
//    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
//
//        List<List<Integer>> ans = new ArrayList<>();
//        while (!pq.isEmpty()) {
//            var pair = pq.poll();
//            ans.add(List.of(pair.a, pair.b));
//        }
//        return ans;
//    }
}
