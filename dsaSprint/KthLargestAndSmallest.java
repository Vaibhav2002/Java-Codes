package dsaSprint;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestAndSmallest {

    public static int kthSmallest(int[] arr,int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>(k);
        for(int i:arr){
            min.add(i);
        }
        for(int i= 1;i<k;i++)
            min.poll();
        return min.poll();
    }

    public static int kthLargest(int[] arr,int k) {
        PriorityQueue<Integer> max = new PriorityQueue<>(k,Collections.reverseOrder());
        for(int i:arr){
            max.add(i);
        }
        for(int i= 1;i<k;i++)
            max.poll();
        return max.poll();
    }

    public static void main(String[] args) {
        var array = new int[]{7,10,4,3,20,15};
        int kthSmallest = kthSmallest(array,3);
        int kthLargest = kthLargest(array,3);
        System.out.println(kthLargest+" "+kthSmallest);
    }
}
