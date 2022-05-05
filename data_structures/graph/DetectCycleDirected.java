package data_structures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirected {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        return checkUsingBFS(adj, V);
    }

    private boolean checkUsingDFS(ArrayList<ArrayList<Integer>> adj, int n){
        boolean[] visited = new boolean[n+1];
        boolean[] dfsVisit = new boolean[n+1];
        for(int i=0;i<n;i++){
            if(!visited[i] && checkDFSUtil(i, adj, visited, dfsVisit)) return true;
        }
        return false;
    }

    private boolean checkDFSUtil(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfsVisit){
        visited[i] = true;
        dfsVisit[i] = true;
        for(Integer edge:adj.get(i)){
            if(!visited[edge]) checkDFSUtil(edge, adj, visited, dfsVisit);
            else if(dfsVisit[edge]) return true;
        }
        return false;
    }

    private boolean checkUsingBFS(ArrayList<ArrayList<Integer>> adj, int n){
        Queue<Integer> que = new LinkedList<>();
        var inDegree =getInDegree(adj);
        for(int i = 0;i<n;i++) if(inDegree[i] == 0) que.add(i);
        int count = 0;
        while(!que.isEmpty()){
            var node = que.poll();
            count++;
            for(Integer edge:adj.get(node)){
                inDegree[edge]--;
                if(inDegree[edge] == 0) que.add(edge);
            }
        }
        return count != n;
    }

    private int[] getInDegree(ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[adj.size()];
        for(ArrayList<Integer> i:adj){
            for(Integer j:i) inDegree[j]++;
        }
        return inDegree;
    }

}
