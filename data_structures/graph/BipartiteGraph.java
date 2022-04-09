package data_structures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V+1];
        Arrays.fill(color, -1);
        for(int i=0;i<V;i++){
            if(color[i] == -1 && !checkUsingBFS(adj, i, V, color)) return false;
        }
        return true;
    }
    private boolean checkUsingBFS(ArrayList<ArrayList<Integer>>adj, int i, int v, int color[]){
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        color[i] = 0;
        while (!que.isEmpty()){
            var node = que.poll();
            for(Integer edge:adj.get(node)){
                if(color[edge] == -1){
                    que.add(edge);
                    color[edge] = 1 - color[node];
                }
                else if(color[edge] == color[node]) return false;
            }
        }
        return true;
    }
}
