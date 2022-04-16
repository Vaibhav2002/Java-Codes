package data_structures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirected {

    private static class Node{
        int data, parent;
        Node(int data, int parent){
            this.data = data;
            this.parent = parent;
        }
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V+1];
        for(int i=0;i<V;i++){
            if(!visited[i] && checkUsingBFS(i, adj, visited)) return true;
        }
        return false;
    }

    private boolean checkUsingBFS(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(i, -1));
        visited[i] = true;
        while(!que.isEmpty()){
            var node = que.poll();
            for(Integer edge:adj.get(node.data)){
                if(!visited[edge]){
                    visited[edge] = true;
                    que.add(new Node(edge, node.data));
                }
                else if(node.parent != edge) return true;
            }
        }
        return false;
    }

}
