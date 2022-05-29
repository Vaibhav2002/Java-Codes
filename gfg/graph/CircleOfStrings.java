package gfg.graph;

import java.util.ArrayList;

public class CircleOfStrings {
    static int isCircle(int N, String A[]) {
        var adj = getAdjList(A, N);
        boolean[] visited = new boolean[26];
        for(int i=0;i<26;i++) if(!visited[i] && checkCycleUsingDFS(i, adj, -1, visited)) return 1;
        return 0;
    }

    private static boolean checkCycleUsingDFS(int source, ArrayList<ArrayList<Integer>> adj, int parent, boolean[] visited) {
        visited[source] = true;
        for (Integer edge : adj.get(source)) {
            if (!visited[edge]) checkCycleUsingDFS(edge, adj, source, visited);
            else if (edge != parent) return true;
        }
        return false;
    }

    private static ArrayList<ArrayList<Integer>> getAdjList(String[] words, int n) {
        var adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        for (String word : words) {
            int start = word.charAt(0) - 97;
            int end = word.charAt(word.length() - 1) - 97;
            adj.get(start).add(end);
        }
        return adj;
    }
}
