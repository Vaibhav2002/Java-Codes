package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinNeighboursWithinThreshold {

    private static class Edge{
        int dest, weight;
        Edge(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        var adj = getAdj(edges, n);
        int[][] minDist = new int[n][n];
        for(int[] i:minDist) Arrays.fill(i, Integer.MAX_VALUE);
        for(int i=0;i<n;i++) fillMinDist(i, adj, minDist[i]);
        return getMinCity(minDist, n, distanceThreshold);
    }
    private ArrayList<ArrayList<Edge>> getAdj(int[][] graph, int n){
        var adj = new ArrayList<ArrayList<Edge>>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] i:graph){
            adj.get(i[0]).add(new Edge(i[1], i[2]));
            adj.get(i[1]).add(new Edge(i[0], i[2]));
        }
        return adj;
    }
    private void fillMinDist(int start, ArrayList<ArrayList<Edge>> adj, int[] minDist){
        Queue<Integer> que = new LinkedList<>();
        minDist[start] = 0;
        que.add(start);
        while(!que.isEmpty()){
            var node = que.poll();
            for(Edge edge:adj.get(node)){
                int dist = minDist[node]+edge.weight;
                if(dist<minDist[edge.dest]){
                    minDist[edge.dest] = dist;
                    que.add(edge.dest);
                }
            }
        }
    }
    private int getMinCity(int[][] minDist, int n, int threshold){
        int[] count = new int[n];
        int minCity = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j:minDist[i]) if(j<=threshold) count[i]++;
            if(count[i]<=min){
                min = count[i];
                minCity = i;
            }

        }
        return minCity;
    }
}
