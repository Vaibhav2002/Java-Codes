package leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPaths {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        var adj = getAdjList(graph);
        boolean[] visited = new boolean[graph.length + 1];
        find(adj, 0, graph.length, new ArrayList<>(), ans, visited);
        return ans;
    }

    private ArrayList<ArrayList<Integer>> getAdjList(int[][] graph) {
        var adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < graph.length; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) adj.get(i).add(j);
        }
        return adj;
    }

    private void find(ArrayList<ArrayList<Integer>> adj, int i, int n, ArrayList<Integer> path, List<List<Integer>> ans, boolean[] visited) {
        path.add(i);
        if (i == n - 1) {
            ans.add(path);
            return;
        }
        visited[i] = true;
        for (Integer edge : adj.get(i)) {
            if (!visited[edge])
                find(adj, edge, n, new ArrayList<>(path), ans, visited);
        }
        visited[i] = false;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };
        AllPaths ob = new AllPaths();
        System.out.println(ob.allPathsSourceTarget(graph));
    }
}
