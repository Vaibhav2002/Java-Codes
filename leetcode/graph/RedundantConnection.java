package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RedundantConnection {

    private static class Node{
        int val, parent;
        Node(int val, int parent){
            this.val = val;
            this.parent = parent;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int v = getNumberOfNodes(edges);
        var adj = getAdjList(edges, v);
        boolean[] visited = new boolean[v+1];
        int[] redundant = getCyclePointDFS(adj, new Node(1, -1), visited);
        return redundant;
    }

    private int[] getCyclePoint(ArrayList<ArrayList<Integer>> adj, int i, int v, boolean[] visited){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(i, -1));
        visited[i] = true;
        while(!que.isEmpty()){
            var node = que.poll();
            for(Integer edge:adj.get(node.val)){
                if(!visited[edge]){
                    que.add(new Node(edge, node.val));
                    visited[edge] = true;
                }
                else if(edge != node.parent) return new int[]{edge, node.val};
            }
        }
        return new int[]{};
    }

    private int[] getCyclePointDFS(ArrayList<ArrayList<Integer>> adj, Node node, boolean[] visited){
        visited[node.val] = true;
        for(Integer edge:adj.get(node.val)){
            if(!visited[edge]) {
                var e = getCyclePointDFS(adj, new Node(edge, node.val), visited);
                if(e.length==2) return e;
            }
            else if(node.parent != edge) return new int[]{edge, node.val};
        }
        return new int[]{};
    }

    private int getNumberOfNodes(int[][] graph){
        int v = 0;
        for(int[] edge:graph){
            v = Math.max(v, Math.max(edge[0], edge[1]));
        }
        return v;
    }
    private ArrayList<ArrayList<Integer>> getAdjList(int[][] graph, int v){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=v;i++) adj.add(new ArrayList<>());
        for(int[] edge:graph){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
}
