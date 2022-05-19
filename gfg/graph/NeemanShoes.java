package gfg.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NeemanShoes {

    private static class Edge{
        int dest, weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    public String exercise(int N, int M, ArrayList<ArrayList<Integer>> A, int src, int dest, int X)
    {
        var adj = getAdj(A, N);
        var minPath = findMinPath(adj, src, dest, N);
        if(minPath<=X) return "Neeman's Cotton Classics";
        else return "Neeman's Wool Joggers";
    }

    private int findMinPath(ArrayList<ArrayList<Edge>> adj, int src, int dest, int n){
        var distToAllNodes = findDistToAllNodes(adj, src, n);
        return distToAllNodes[dest];
    }

    private int[] findDistToAllNodes(ArrayList<ArrayList<Edge>> adj, int src, int n){
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>(n, Comparator.comparingInt((Edge edge)->edge.weight));
        cost[src] = 0;
        pq.add(new Edge(src, cost[src]));
        while(!pq.isEmpty()){
            var node = pq.poll();
            if(cost[node.dest] == Integer.MAX_VALUE) continue;
            for(Edge edge:adj.get(node.dest)){
                int len = cost[node.dest]+edge.weight;
                if(len<cost[edge.dest]){
                    cost[edge.dest] = len;
                    pq.add(edge);
                }
            }
        }
        return cost;
    }

    private ArrayList<ArrayList<Edge>> getAdj(ArrayList<ArrayList<Integer>> adj, int n){
        var ans = new ArrayList<ArrayList<Edge>>();
        for(int i=0;i<n;i++) ans.add(new ArrayList<>());
        for(ArrayList<Integer> i:adj){
            ans.get(i.get(0)).add(new Edge(i.get(1), i.get(2)));
            ans.get(i.get(1)).add(new Edge(i.get(0), i.get(2)));
        }
        return ans;
    }
}
