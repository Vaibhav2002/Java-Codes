package leetcode.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        var adj = getAdj(n, edges);
        var order = findOrder(adj, n);
        Queue<Integer> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) if (order[i] == 1) que.add(i);
        while (que.size() > 2) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                var node = que.poll();
                if(node == null) continue;
                for(Integer edge:adj.get(node)){
                    order[edge]--;
                    if(order[edge] == 1) que.add(edge);
                }
            }
        }
        while (!que.isEmpty()) ans.add(que.poll());
        return ans;
    }

    private int[] findOrder(ArrayList<ArrayList<Integer>> adj, int n) {
        int[] order = new int[n];
        for (ArrayList<Integer> i : adj) {
            for (Integer j : i) order[j]++;
        }
        return order;
    }

    private ArrayList<ArrayList<Integer>> getAdj(int n, int[][] graph) {
        var adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] i : graph) {
            int u = i[0], v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}
