package leetcode.heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-k-closest-elements/">Problem</a>
 **/
public class FindKClosestElement {

    private static class Ele implements Comparable<Ele> {
        int data, diff;

        public Ele(int data, int diff) {
            this.data = data;
            this.diff = diff;
        }

        @Override
        public int compareTo(Ele o) {
            int diff = Integer.compare(o.diff, this.diff);
            return (diff!=0)? diff : Integer.compare(o.data, data);
        }
    }


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        var pq = new PriorityQueue<Ele>(k);
        for (int i : arr) {
            pq.offer(new Ele(i, Math.abs(i - x)));
            if (pq.size() > k) pq.poll();
        }
        return pq.stream().map((Ele ele) -> ele.data).sorted().toList();
    }
}
