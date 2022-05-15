package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/network-delay-time/">Problem Link</a>
 */
public class NetworkDelayTime {

    private static class Edge {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        var adj = getAdjList(times, n + 1);
        var dist = getDistToAllNodes(adj, n + 1, k);
        int max = Integer.MIN_VALUE;
        for (int i=1;i<dist.length;i++) max = Math.max(max, dist[i]);
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private ArrayList<ArrayList<Edge>> getAdjList(int graph[][], int n) {
        var adj = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] i : graph) {
            adj.get(i[0]).add(new Edge(i[1], i[2]));
        }
        return adj;
    }

    private int[] getDistToAllNodes(ArrayList<ArrayList<Edge>> adj, int n, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while (!que.isEmpty()) {
            var node = que.poll();
            for (Edge edge : adj.get(node)) {
                int time = edge.weight + dist[node];
                if (time < dist[edge.dest]) {
                    dist[edge.dest] = time;
                    que.add(edge.dest);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        int[][] graph = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        NetworkDelayTime ob = new NetworkDelayTime();
        System.out.println(ob.networkDelayTime(graph, n, k));
    }
}
