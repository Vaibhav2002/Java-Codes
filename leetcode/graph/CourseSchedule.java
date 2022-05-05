package leetcode.graph;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return findUsingBFS(numCourses, prerequisites);
    }
    private boolean findUsingBFS(int numCourses, int[][] prerequisites){
        var adj = getAdjList(prerequisites, numCourses);
        var topoCount = countTopo(adj, numCourses);
        return numCourses == topoCount;
    }
    private boolean findUsingDFS(int numCourses, int[][] prerequisites){
        var adj = getAdjList(prerequisites, numCourses);
        boolean[] visited = new boolean[numCourses], dfsVisit = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && dfsCycleCheck(i, adj, visited, dfsVisit)) return false;
        }
        return true;
    }
    private ArrayList<ArrayList<Integer>> getAdjList(int[][] graph, int n){
        var adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] i:graph){
            adj.get(i[0]).add(i[1]);
        }
        return adj;
    }

    private boolean dfsCycleCheck(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfsVisit){
        visited[node] = dfsVisit[node] = true;
        for(Integer edge:adj.get(node)){
            if(!visited[edge])
                if(dfsCycleCheck(edge, adj, visited, dfsVisit)) return true;
            if(dfsVisit[edge]) return true;
        }
        dfsVisit[node] = false;
        return false;
    }


    private int countTopo(ArrayList<ArrayList<Integer>> adj, int n){
        Queue<Integer> que = new LinkedList<>();
        int[] inDegree = getInDegree(adj, n);
        for(int i=0;i<inDegree.length;i++) if(inDegree[i] == 0) que.add(i);
        int count =0;
        while(!que.isEmpty()){
            var node = que.poll();
            count++;
            for(Integer edge:adj.get(node)){
                inDegree[edge]--;
                if(inDegree[edge] == 0) que.add(edge);
            }
        }
        return count;
    }
    private int[] getInDegree(ArrayList<ArrayList<Integer>> adj, int n){
        int[] inDegree = new int[n];
        for(ArrayList<Integer> i:adj){
            for(Integer j:i) inDegree[j]++;
        }
        return inDegree;
    }
}
