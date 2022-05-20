package leetcode.graph;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
//        var adj= getAdjList(pairs, n);
        return solveUsingDSU(s.toCharArray(), pairs, n);
    }

    private String solveUsingDFS(char[] s, List<List<Integer>> adj, int n){
        boolean[] visited = new boolean[n];
        char[] ans = new char[n];
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                List<Integer> dfsList = new ArrayList<>();
                List<Character> chars = new ArrayList<>();
                dfs(i, adj, visited, dfsList, chars, s);
                Collections.sort(chars);
                Collections.sort(dfsList);
                for(int k=0;k<chars.size();k++) ans[dfsList.get(k)] = chars.get(k);
            }
        }
        return new String(ans);
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> dfsList, List<Character> chars, char[] s){
        visited[node] = true;
        dfsList.add(node);
        chars.add(s[node]);
        for(Integer edge:adj.get(node)){
            if(!visited[edge]) dfs(edge, adj, visited, dfsList, chars, s);
        }
    }

    private List<List<Integer>> getAdjList(List<List<Integer>> pairs, int n){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(List<Integer> pair:pairs){
            adj.get(pair.get(0)).add(pair.get(1));
            adj.get(pair.get(1)).add(pair.get(0));
        }
        return adj;
    }

    private String solveUsingDSU(char[] s, List<List<Integer>> pairs, int n){
        DisjointSet ob = new DisjointSet(n);
        for(List<Integer> pair:pairs)
            ob.union(pair.get(0), pair.get(1));
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.putIfAbsent(i, new ArrayList<>());
            map.get(ob.find(i)).add(i);
        }
        char ans[] = new char[n];
        for(List<Integer> index:map.values()){
            var chars = index.stream().map((Integer e)->s[e]).sorted().toList();
            Collections.sort(index);
            for(int i = 0;i<index.size();i++) ans[index.get(i)] = chars.get(i);
        }
        return new String(ans);
    }
}
