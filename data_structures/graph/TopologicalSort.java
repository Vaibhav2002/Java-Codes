package data_structures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] topo = new int[V+1];
        topoSortUsingBFS(adj, topo, V);
        return topo;
    }

    private static void topoSortUsingDFS(ArrayList<ArrayList<Integer>> adj, int[] topo, int n){
        int index = 0;
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n+1];
        for(int i =0;i<n;i++) if(!visited[i]) dfsUtil(i, adj, st, visited);
        while(!st.isEmpty()) topo[index++] = st.pop();
    }

    private static void dfsUtil(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[] visited){
        visited[i] = true;
        for(Integer edge:adj.get(i)){
            if(!visited[edge]) dfsUtil(edge, adj, st, visited);
        }
        st.push(i);
    }

    private static void topoSortUsingBFS(ArrayList<ArrayList<Integer>> adj, int[] topo, int n){
        Queue<Integer> que = new LinkedList<>();
        var inDegree = getInDegree(adj);
        int index = 0;
        for(int i=0;i<n;i++) if(inDegree[i] == 0) que.add(i);
        while(!que.isEmpty()){
            var node = que.poll();
            topo[index++] = node;
            for(Integer edge:adj.get(node)){
                inDegree[edge]--;
                if(inDegree[edge] ==0) que.add(edge);
            }
        }
    }

    private static int[] getInDegree(ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[adj.size()];
        for(ArrayList<Integer> i:adj){
            for(Integer j:i) indegree[j]++;
        }
        return indegree;
    }
}
