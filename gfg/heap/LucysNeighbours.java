package gfg.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LucysNeighbours {
    public ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int dist1 = Math.abs(o1 - x);
            int dist2 = Math.abs(o2 - x);
            int diff = Integer.compare(dist2, dist1);
            return (diff != 0) ? diff : Integer.compare(o2, o1);
        });
        for(int i:arr){
            pq.add(i);
            if(pq.size()>k) pq.poll();
        }
        var ans = new ArrayList<Integer>();
        while(!pq.isEmpty()) ans.add(pq.poll());
        return ans;
    }
}
