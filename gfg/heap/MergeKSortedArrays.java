package gfg.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1/?page=1&difficulty[]=1&status[]=unsolved&category[]=Heap&sortBy=submissions">Problem</a>
 **/
public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        var pq = new PriorityQueue<Integer>();
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++)
                pq.add(arr[i][j]);
        }
        return new ArrayList<>(pq);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {57, 81},
                {63, 71}
        };
        int k =2;
        System.out.println(mergeKArrays(arr, k).toString());
    }
}
