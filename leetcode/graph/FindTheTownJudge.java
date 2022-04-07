package leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        var adj = getAdjacencyList(trust, n);
        int followsNobody = followsNobody(adj, n);
        if (followsNobody == -1) return followsNobody;
        return (doesEveryoneFollows(adj, n, followsNobody)) ? followsNobody : -1;
    }

    private boolean doesEveryoneFollows(ArrayList<HashSet<Integer>> adj, int n, int target) {
        for (int i = 1; i <= n; i++) {
            if (i == target) continue;
            if (!adj.get(i).contains(target)) return false;
        }
        return true;
    }

    private int followsNobody(ArrayList<HashSet<Integer>> adj, int n) {
        int index = -1;
        for (int i = 1; i <= n; i++) {
            if (adj.get(i).isEmpty() && index != -1) return -1;
            if (adj.get(i).isEmpty()) index = i;
        }
        return index;
    }

    private ArrayList<HashSet<Integer>> getAdjacencyList(int[][] graph, int n) {
        var adj = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i <= n; i++) adj.add(new HashSet<>());
        for (int[] edge : graph) adj.get(edge[0]).add(edge[1]);
        return adj;
    }
}
