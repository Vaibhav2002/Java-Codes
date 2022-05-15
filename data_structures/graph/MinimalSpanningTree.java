package data_structures.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimalSpanningTree {

    private static class Edge {
        int dest, weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    ArrayList<ArrayList<Integer>> findMST(ArrayList<ArrayList<Edge>> adj, int n) {
        int[] parent = new int[n], weight = new int[n];
        getMSTArray(0, adj, n, parent, weight);
        var ans = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<n;i++) ans.add(new ArrayList<>());
        for(int i = 1;i<n;i++) ans.get(parent[i]).add(i);
        return ans;
    }

    int findMSTSum(ArrayList<ArrayList<Edge>> adj, int n){
        int[] parent = new int[n], weight = new int[n];
        getMSTArray(0, adj, n, parent, weight);
        int sum = 0;
        for(int w:weight) sum+=w;
        return sum;
    }

    private void getMSTArray(int source, ArrayList<ArrayList<Edge>> adj, int n, int[] parent, int[] weight) {
        boolean[] inMst = new boolean[n];
        initArrays(n, parent, weight, inMst);
        PriorityQueue<Edge> pq = new PriorityQueue<>(n, Comparator.comparingInt((Edge edge) -> edge.weight));
        inMst[source] = true;
        weight[source] = 0;
        pq.add(new Edge(source, 0));
        for(int i=0;i<n-1;i++){
            var node = pq.poll().dest;
            inMst[node] = true;
            for(Edge edge:adj.get(node)){
                if(!inMst[edge.dest] && edge.weight < weight[edge.dest]){
                    parent[edge.dest] = node;
                    weight[edge.dest] = edge.weight;
                    pq.add(edge);
                }
            }
        }
    }

    private void initArrays(int n, int[] parent, int[] weight, boolean[] inMst) {
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            inMst[i] = false;
            weight[i] = Integer.MAX_VALUE;
        }
    }

    private ArrayList<ArrayList<Edge>> getSampleGraph(int n){
        var adj = new ArrayList<ArrayList<Edge>>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Edge(1, 2));
        adj.get(1).add(new Edge(0, 2));

        adj.get(1).add(new Edge(2, 3));
        adj.get(2).add(new Edge(1, 3));

        adj.get(0).add(new Edge(3, 6));
        adj.get(3).add(new Edge(0, 6));

        adj.get(1).add(new Edge(3, 8));
        adj.get(3).add(new Edge(1, 8));

        adj.get(1).add(new Edge(4, 5));
        adj.get(4).add(new Edge(1, 5));

        adj.get(2).add(new Edge(4, 7));
        adj.get(4).add(new Edge(2, 7));
        return adj;
    }

    public static void main(String[] args) {
        int n = 5;
        MinimalSpanningTree ob = new MinimalSpanningTree();
        var adj = ob.getSampleGraph(n);
        var mst = ob.findMST(adj, n);
        var mstSum = ob.findMSTSum(adj, n);
        System.out.println(mst.toString());
        System.out.println(mstSum);
    }
}
