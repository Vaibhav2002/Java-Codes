package leetcode.heap;

import java.util.PriorityQueue;

/**
* <a href="https://leetcode.com/problems/ugly-number-ii/">Problem</a>
**/
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        while(!pq.isEmpty() && --n>0){
            var num = pq.poll();
            if(num<Integer.MAX_VALUE/2 &&!pq.contains(num*2))
            pq.add(num*2);
            if(num<Integer.MAX_VALUE/3 &&!pq.contains(num*3))
            pq.add(num*3);
            if(num<Integer.MAX_VALUE/5 && !pq.contains(num*5))
            pq.add(num*5);
        }
        return pq.poll();
    }
}
