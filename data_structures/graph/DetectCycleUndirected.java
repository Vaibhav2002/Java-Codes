package data_structures.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirected {

    static class Node {
        int val, parent;

        Node(int val, int parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            if (!visited[i] && checkUsingBFS(adj, i, visited)) return true;
        }
        return false;
    }

    private boolean checkUsingBFS(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(i, -1));
        visited[i] = true;
        while (!que.isEmpty()) {
            var node = que.poll();
            for (Integer edge : adj.get(node.val)) {
                if (!visited[edge]) {
                    que.add(new Node(edge, node.val));
                    visited[edge] = true;
                } else if (node.parent != edge) return true;
            }
        }
        return false;
    }

    private boolean checkUsingDFS(ArrayList<ArrayList<Integer>> adj, int i, int parent, boolean[] visited) {
        visited[i] = true;
        for(Integer edge:adj.get(i)){
            if(!visited[edge]){
                if(checkUsingDFS(adj, edge, i, visited)) return true;
            }
            else if(edge != parent) return true;
        }
        return false;
    }
}
