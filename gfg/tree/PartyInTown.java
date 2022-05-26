package gfg.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PartyInTown {

    static int partyHouse(int n, ArrayList<ArrayList<Integer>> adj)
    {
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            var dist = getDist(i, adj, n);
            int maxDist = getMaxDist(dist);
            ans = Math.min(ans, maxDist);
        }
        return ans;
    }

    private static int getMaxDist(int[] dist){
        int max = Integer.MIN_VALUE;
        for(int i:dist) max = Math.max(i, max);
        return max;
    }

    static int[] getDist(int start, ArrayList<ArrayList<Integer>> adj, int n){
        int[] dist = new int[n];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        dist[start] = 0;
        while (!que.isEmpty()){
            var node = que.poll();
            for(Integer edge:adj.get(node-1)){
                int len = dist[node]+1;
                if(len < dist[edge]){
                    dist[edge] = len;
                    que.add(edge);
                }
            }
        }
        return dist;
    }
}
