package data_structures.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajuStronglyConnectedComponents {

    private void getTopSort(int source, ArrayList<ArrayList<Integer>> adj, Stack<Integer> topo, boolean[] visited) {
        visited[source] = true;
        for (Integer edge : adj.get(source)) {
            if (!visited[edge]) getTopSort(edge, adj, topo, visited);
        }
        topo.push(source);
    }

    private ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> adj, int n) {
        var trans = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) trans.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (Integer dest : adj.get(i)) trans.get(dest).add(i);
        }
        return trans;
    }

    private void fillRevDFS(int source, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, boolean[] visited) {
        dfs.add(source);
        visited[source] = true;
        for (Integer edge : adj.get(source)) {
            if (!visited[edge]) fillRevDFS(edge, adj, dfs, visited);
        }
    }

    private ArrayList<ArrayList<Integer>> getSSC(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        var topoSort = new Stack<Integer>();
        for (int i = 0; i < n; i++) if (!visited[i]) getTopSort(i, adj, topoSort, visited);
        var transpose = getTranspose(adj, n);
        Arrays.fill(visited, false);
        var ssc = new ArrayList<ArrayList<Integer>>();
        while (!topoSort.isEmpty()) {
            var node = topoSort.pop();
            if (!visited[node]) {
                var sscList = new ArrayList<Integer>();
                fillRevDFS(node, transpose, sscList, visited);
                ssc.add(sscList);
            }
        }
        return ssc;
    }

    public static void main(String[] args) {
        int n = 7;
        var adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(3).add(2);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(4);
        adj.get(6).add(5);
        KosarajuStronglyConnectedComponents ob = new KosarajuStronglyConnectedComponents();
        System.out.println(ob.getSSC(adj, n).toString());
    }
}
