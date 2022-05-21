package leetcode.graph;

import java.lang.reflect.Array;
import java.util.*;

/**
 * <a href="https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/">Problem</a>
 */
public class AncestorsOfNode {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<n;i++) ans.add(new ArrayList<>());
        var adj = getAdjList(edges, n);
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]) solveUsingBFS(i, adj, ans, visited);
        }
        return ans;
    }

    private void solveUsingBFS(int start, ArrayList<TreeSet<Integer>> adj, List<List<Integer>> ans, boolean[] visited){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        while(!que.isEmpty()){
            var node = que.poll();
            for (Integer edge:adj.get(node)){
                ans.get(edge).add(node);
                if(!visited[edge]) que.add(edge);
            }
        }
    }

    private ArrayList<TreeSet<Integer>> getAdjList(int[][] edges, int n){
        var adj = new ArrayList<TreeSet<Integer>>();
        for(int i=0;i<n;i++) adj.add(new TreeSet<>());
        for(int[] i:edges){
            adj.get(i[0]).add(i[1]);
        }
        return adj;
    }
}
