package leetcode.heap;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/reduce-array-size-to-the-half/">Problem</a>
 */
public class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        for(int i:arr) map.merge(i, 1, Integer::sum);
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.addAll(map.values());
        int size = arr.length;
        int count = 0;
        while(!pq.isEmpty()&& size > arr.length/2){
            count++;
            size -= pq.poll();
        }
        return count;
    }
}
