package gfg.graph;

import java.util.ArrayList;

public class CountThePaths {

    public int possible_paths(int[][] edges, int n, int s, int d) {
        var adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[n + 1];
        return count(s, adj, d, visited);
    }

    private int count(int i, ArrayList<ArrayList<Integer>> adj, int dest, boolean[] visited) {
        if (i == dest) return 1;
        visited[i] = true;
        int sum = 0;
        for (Integer edge : adj.get(i)) {
            if (!visited[edge]) sum += count(edge, adj, dest, visited);
        }
        visited[i] = false;
        return sum;
    }
}
