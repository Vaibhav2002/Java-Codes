package gfg.graph;

import java.util.*;

public class ShortestPath {

    private static class Edge{
        int dest, weight;
        Edge(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }

    public int findShortestPath(int source, int dest, ArrayList<ArrayList<Edge>> adj, int n){
        int[] shortestPathsToAllNodes = findShortestPath(source, adj, n);
        return shortestPathsToAllNodes[dest];
    }

    private int[] findShortestPath(int source, ArrayList<ArrayList<Edge>> adj, int n){
        int[] path = new int[n];
        findShortestPathUsingBFS(source, adj, path);
        return path;
    }

    private void findShortestPathUsingBFS(int source, ArrayList<ArrayList<Edge>> adj, int[] path){
        Arrays.fill(path, Integer.MAX_VALUE);
        path[source] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        while(!que.isEmpty()){
            var node = que.poll();
            for(Edge edge:adj.get(node)){
                int len = path[node]+edge.weight;
                if(len<path[edge.dest]){
                    path[edge.dest] = len;
                    que.add(edge.dest);
                }
            }
        }
    }

    private void fillSampleAdj(ArrayList<ArrayList<Edge>> adj, int n){
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Edge(1, 2));
        adj.get(0).add(new Edge(4, 1));
        adj.get(1).add(new Edge(2, 3));
        adj.get(2).add(new Edge(3, 6));
        adj.get(4).add(new Edge(2, 2));
        adj.get(4).add(new Edge(5, 4));
        adj.get(5).add(new Edge(3, 1));
    }

    public static void main(String[] args) {
        var adj = new ArrayList<ArrayList<Edge>>();
        int n = 6;
        ShortestPath ob = new ShortestPath();
        ob.fillSampleAdj(adj, n);
        System.out.println(Arrays.toString(ob.findShortestPath(0, adj, n)));
    }
}
