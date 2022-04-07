package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int count =0;
        int v = isConnected.length;
        boolean[] visited = new boolean[v+1];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }

    private void bfs(int i, int[][] graph, boolean[] visited){
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        visited[i] = true;
        while(!que.isEmpty()){
            var node = que.poll();
            for(int j=0;j<graph[node].length;j++){
                if(!visited[j]){
                    que.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    private void dfs(int i, int[][] graph, boolean[] visited){
        visited[i] = true;
        for(int edge = 0;edge<graph[i].length;edge++){
            if(!visited[edge] && graph[i][edge] == 1 && edge!=i){
                visited[edge] = true;
                bfs(edge, graph, visited);
            }
        }
    }
}
