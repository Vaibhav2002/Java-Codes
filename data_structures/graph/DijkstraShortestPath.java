package data_structures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

    private static class Edge {
        int dest, weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    int findShortestPath(int source, int dest, ArrayList<ArrayList<Edge>> adj, int n) {
        var dist = getShortestPathToAllNodeS(source, adj, n);
        return dist[dest];
    }

    private int[] getShortestPathToAllNodeS(int source, ArrayList<ArrayList<Edge>> adj, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>(n, Comparator.comparingInt((Edge e) -> e.weight));
        dist[source] = 0;
        pq.add(new Edge(source, 0));
        while (!pq.isEmpty()) {
            var node = pq.poll();
            if (dist[node.dest] == Integer.MAX_VALUE) continue;
            for (Edge edge : adj.get(node.dest)) {
                int len = dist[node.dest] + edge.weight;
                if (len < dist[edge.dest]) {
                    dist[edge.dest] = len;
                    pq.add(edge);
                }
            }
        }
        return dist;
    }

    private void fillSampleAdj(ArrayList<ArrayList<Edge>> adj, int n) {
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(0).add(new Edge(1, 2));
        adj.get(0).add(new Edge(4, 1));
        adj.get(0).add(new Edge(2, 3));
        adj.get(2).add(new Edge(5, 6));
        adj.get(4).add(new Edge(2, 2));
        adj.get(4).add(new Edge(5, 4));
        adj.get(5).add(new Edge(3, 1));
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        DijkstraShortestPath ob = new DijkstraShortestPath();
        ob.fillSampleAdj(adj, n);
        System.out.println(ob.findShortestPath(0, 5, adj, n));
    }
}
