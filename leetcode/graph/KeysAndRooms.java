package leetcode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> que = new LinkedList<>();
        HashSet<Integer> opened = new HashSet<>();
        int n = rooms.size();
        boolean[] visited = new boolean[n + 1];
        que.add(0);
        visited[0] = true;
        while (!que.isEmpty()) {
            var node = que.poll();
            opened.add(node);
            visited[node] = true;
            if (opened.size() == n) return true;
            for (Integer edge : rooms.get(node)) {
                if (!visited[edge]) {
                    que.offer(edge);
                    visited[edge] = true;
                }
            }
        }
        return opened.size() == n;
    }
}
