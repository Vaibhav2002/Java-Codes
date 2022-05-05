package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var adj = getAdjList(prerequisites, numCourses);
        return findUsingDFS(adj, numCourses);
    }

    private ArrayList<ArrayList<Integer>> getAdjList(int[][] graph, int n){
        var adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] i:graph){
            adj.get(i[0]).add(i[1]);
        }
        return adj;
    }

    private int[] findUsingDFS(ArrayList<ArrayList<Integer>> adj, int n){
        Queue<Integer> que = new LinkedList<>();
        int[] topo = new int[n];
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) if(!visited[i]) fillDFS(i, adj, que, visited);
        int index = 0;
        while (!que.isEmpty()) topo[index++] = que.poll();
        return topo;
    }

    private void fillDFS(int node, ArrayList<ArrayList<Integer>> adj, Queue<Integer> que, boolean[] visited){
        visited[node] = true;
        for(Integer edge:adj.get(node)){
            if(!visited[edge]) fillDFS(edge, adj, que, visited);
        }
        que.add(node);
    }

    private int[] findUsingBFS(ArrayList<ArrayList<Integer>> adj, int n){
        Queue<Integer> que = new LinkedList<>();
        var inDegree = getInDegree(adj, n);
        for(int i=0;i<n;i++) if(inDegree[i] == 0) que.add(i);
        int[] topo = new int[n];
        int index = 0;
        while(!que.isEmpty()){
            var node = que.poll();
            topo[index++] = node;
            for(Integer edge:adj.get(node)){
                inDegree[edge]--;
                if(inDegree[edge] == 0) que.add(edge);
            }
        }
        if(index !=-1) return new int[]{};
        return topo;
    }

    private int[] getInDegree(ArrayList<ArrayList<Integer>> adj, int n){
        int[] inDegree = new int[n];
        for(ArrayList<Integer> i:adj) for(Integer j:i) inDegree[j]++;
        return inDegree;
    }
}
