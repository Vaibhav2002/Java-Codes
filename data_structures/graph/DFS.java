package data_structures.graph;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfs(int v, ArrayList<ArrayList<Integer>> adj){
        var ans = new ArrayList<Integer>();
        boolean[] visited = new boolean[v+1];
        dfsUtil(0, adj, ans, visited);
        return ans;
    }
    private void dfsUtil(int i, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] visited){
        ans.add(i);
        visited[i] = true;
        for(Integer edge:adj.get(i)) if(!visited[edge]) dfsUtil(edge, adj, ans, visited);
    }
}
