package gfg.graph;

import java.util.ArrayList;

public class BridgeEdge {
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d)
    {
        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));
        return isBridge(adj, V)?1:0;
    }
    private static boolean isBridge(ArrayList<ArrayList<Integer>> adj, int n){
        boolean[] visited = new boolean[n];
        dfs(0, adj, visited);
        for(int i=0;i<n;i++) if(!visited[i]) return true;
        return false;
    }
    private static void dfs(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node] = true;
        for(Integer edge:adj.get(node)){
            if(!visited[edge]){
                dfs(edge, adj, visited);
            }
        }
    }
}
