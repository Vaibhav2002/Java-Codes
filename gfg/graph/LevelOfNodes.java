package gfg.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOfNodes {

    private static class Node{
        int data, level;

        public Node(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    int nodeLevel(int n, ArrayList<ArrayList<Integer>> adj, int x)
    {
        boolean[] visited = new boolean[n];
        return findUsingBFS(n, adj, x, visited);
    }

    private int findUsingBFS(int n, ArrayList<ArrayList<Integer>> adj, int x, boolean[] visited){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        visited[0] = true;
        while(!que.isEmpty()){
            var node = que.poll();
            if(node.data == x) return node.level;
            for(Integer edge:adj.get(node.data)){
                if(!visited[edge]) {
                    que.add(new Node(edge, node.level + 1));
                    visited[edge] = true;
                }
            }
        }
        return -1;
    }
}
