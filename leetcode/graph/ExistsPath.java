package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ExistsPath {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return contains(adj, n, source, destination);
    }

    private boolean contains(ArrayList<ArrayList<Integer>> adj, int n, int source, int dest) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        que.add(source);
        visited[source] = true;
        while (!que.isEmpty()) {
            var edge = que.poll();
            if (edge == dest) return true;
            for (Integer i : adj.get(edge)) {
                if(i == dest) return true;
                if (!visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }
}
