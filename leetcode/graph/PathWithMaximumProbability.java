package leetcode.graph;

import java.util.ArrayList;

public class PathWithMaximumProbability {

    private static class Edge{
        int to;
        double prob;
        Edge(int to, double prob){
            this.to = to;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        boolean[] visited = new boolean[n+1];
        var adj = getAdjList(edges, succProb);
        return findUsingDFS(start, adj, end, visited);

    }
    private ArrayList<ArrayList<Edge>> getAdjList(int[][] adj, double[] prob){
        var ans = new ArrayList<ArrayList<Edge>>();
        for(int i=0;i< adj.length;i++) ans.add(new ArrayList<>());
        for(int i=0;i<adj.length;i++){
            ans.get(adj[i][0]).add(new Edge(adj[i][1], prob[i]));
        }
        return ans;
    }

    private double findUsingDFS(int i, ArrayList<ArrayList<Edge>> adj, int target, boolean[] visited){
        if(i == target) return 1;
        visited[i] = true;
        double max = 0;
        for(Edge edge:adj.get(i)){
            if(!visited[edge.to])
                max = Math.max(max, edge.prob*findUsingDFS(edge.to, adj, target, visited));
        }
        visited[i] = false;
        return max;
    }
}
