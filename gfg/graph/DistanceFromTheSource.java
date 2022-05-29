package gfg.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1">Problem</a>
 */
public class DistanceFromTheSource {
    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> adj, int S)
    {
        int[] dist = new int[n];
        Arrays.fill(dist, 100000000);
        dist[S] = 0;
        for(int i=0;i<n-1;i++){
            for(ArrayList<Integer> edge:adj){
                int len = dist[edge.get(0)]+edge.get(2);
                if(len < dist[edge.get(1)]){
                    dist[edge.get(1)] = len;
                }
            }
        }
        return dist;

    }


}
