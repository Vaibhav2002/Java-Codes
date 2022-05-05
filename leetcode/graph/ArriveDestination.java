package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/">Problem Link</a>
 */
public class ArriveDestination {
    private static class Edge {
        int dest, time;

        Edge(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {
        var adj = getAdjList(n, roads);
        var map = new HashMap<Integer, Integer>();
        boolean[] visited = new boolean[n];
        dfs(0, n - 1, 0, adj, visited, map);
        int minTime = Integer.MAX_VALUE;
        int ans = 0;
        for (Integer time : map.keySet()) {
            if (time < minTime) {
                minTime = time;
                ans = map.getOrDefault(time, 0);
            }
        }
        return ans;
    }

    private ArrayList<ArrayList<Edge>> getAdjList(int n, int[][] roads) {
        var adj = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] i : roads) {
            adj.get(i[0]).add(new Edge(i[1], i[2]));
            adj.get(i[1]).add(new Edge(i[0], i[2]));
        }
        return adj;
    }

    private void dfs(int source, int dest, int time, ArrayList<ArrayList<Edge>> adj, boolean[] visited, HashMap<Integer, Integer> map) {
        if (source == dest) map.merge(time, 1, Integer::sum);
        visited[source] = true;
        for (Edge edge : adj.get(source)) {
            if (!visited[edge.dest]) {
                dfs(edge.dest, dest, time + edge.time, adj, visited, map);
            }
        }
        visited[source] = false;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {
                4, 6, 2}};
        ArriveDestination ob = new ArriveDestination();
        System.out.println(ob.countPaths(n, roads));
    }
}
