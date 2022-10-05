package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
* <a href="https://leetcode.com/problems/cheapest-flights-within-k-stops/">Problem</a>
**/
public class CheapestFlightsWithinKStops {

    private static class Edge{
        int dest, weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var adj = getAdjList(flights, n);
        return findUsingBFS(adj, src, dst, k, n);
    }

    private int findUsingBFS(ArrayList<ArrayList<Edge>> adj, int src, int dest, int k, int n){
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt((Edge e)->e.weight));
        int cost[] = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        pq.add(new Edge(src, 0));
        int ans = Integer.MAX_VALUE;
        while(!pq.isEmpty() && k>0){
            int len = pq.size();
            for(int i=0;i<len;i++){
                var node = pq.poll();
                if(node == null) continue;
                if (cost[node.dest] == Integer.MAX_VALUE) continue;
                for(Edge edge:adj.get(node.dest)){
                    int le = cost[node.dest]+edge.weight;
                    if(le < cost[edge.dest]) {
                        cost[edge.dest] = le;
                        pq.add(edge);
                    }
                    if(node.dest == dest) ans = Math.min(ans, le);

                }
                k--;
                if(ans != Integer.MAX_VALUE) return ans;
            }
        }
        return -1;
    }

    private ArrayList<ArrayList<Edge>> getAdjList(int[][] graph, int n){
        var adj = new ArrayList<ArrayList<Edge>>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] i:graph) adj.get(i[0]).add(new Edge(i[1], i[2]));
        return adj;
    }
}
