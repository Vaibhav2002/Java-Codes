package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule4 {

    private boolean[][] canReach;

    private void fillCanReach(List<List<Integer>> adj, int n){
        canReach = new boolean[n][n];
        for(int i=0;i<n;i++){
            fill(adj, i, new boolean[n]);
        }
    }

    private void fill(List<List<Integer>> adj, int start, boolean[] visited){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        while(!que.isEmpty()){
             var node = que.poll();
             canReach[start][node] = true;
             for(Integer edge:adj.get(node)){
                 if(!visited[edge]){
                     visited[edge] = true;
                     que.add(edge);
                 }
             }
        }
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        var adj = getAdjList(prerequisites, numCourses);
        fillCanReach(adj, numCourses);
        List<Boolean> ans = new ArrayList<>();
        for(int[] query:queries){
            ans.add(canReach[query[0]][query[1]]);
        }
        return ans;
    }

    private List<List<Integer>> getAdjList(int[][] graph, int n){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] i:graph) adj.get(i[0]).add(i[1]);
        return adj;
    }
}
