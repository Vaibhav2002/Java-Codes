package data_structures.graph;

import java.util.ArrayList;

public class PossiblePaths {
    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source, int dest) {
        boolean visited[] = new boolean[V+1];
        return findUsingDFS(source, adj, dest, visited);
    }

    private int findUsingDFS(int i, ArrayList<ArrayList<Integer>> adj, int dest, boolean[] visited){
        if(i == dest) return 1;
        visited[i] = true;
        int sum = 0;
        for(Integer edge:adj.get(i)){
            if(!visited[edge]){
                sum+=findUsingDFS(edge, adj, dest, visited);
            }
        }
        visited[i] = false;
        return sum;
    }
}