package data_structures.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (visited[i]) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                var node = queue.poll();
                ans.add(node);
                for (Integer edge : adj.get(node)) {
                    if (!visited[edge]) {
                        queue.add(edge);
                        visited[edge] = true;
                    }
                }
            }
        }
        return ans;
    }
}
