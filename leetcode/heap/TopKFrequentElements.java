package leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
* <a href="https://leetcode.com/problems/top-k-frequent-elements/">Problem</a>
**/
public class TopKFrequentElements {

    private static class Ele{
        int data, freq;
        Ele(int data, int freq){
            this.data = data;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for(int i:nums) map.merge(i, 1, Integer::sum);
        var pq = new PriorityQueue<Ele>(k, Comparator.comparingInt((Ele el)->el.freq));
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            pq.add(new Ele(entry.getKey(), entry.getValue()));
            if(pq.size()>k) pq.poll();
        }
        int[] ans = new int[pq.size()];
        int index =0;
        while(!pq.isEmpty()) ans[index++] = pq.poll().data;
        return ans;
    }
}
