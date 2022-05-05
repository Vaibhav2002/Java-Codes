package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        var adj = getAdjList(n, edges);
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans.add(i);
                dfs(i, adj, visited);
            }
        }
        return ans;
    }

    private void dfs(int i, List<List<Integer>> adj, boolean[] visited) {
        visited[i] = true;
        for (Integer edge : adj.get(i)) {
            if (!visited[edge]) dfs(edge, adj, visited);
        }
    }

    private List<List<Integer>> getAdjList(int n, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
        }
        return adj;
    }
}
