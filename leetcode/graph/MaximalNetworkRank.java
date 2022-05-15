package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int ans = Integer.MIN_VALUE;
        boolean[][] isConnected = new boolean[n][n];
        int[] degree = new int[n];
        fill(roads, n, isConnected, degree);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = degree[i] + degree[j];
                if (isConnected[i][j]) count--;
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    private void fill(int[][] graph, int n, boolean[][] isConnected, int[] degree) {
        for (int[] i : graph) {
            isConnected[i[0]][i[1]] = isConnected[i[1]][i[0]] = true;
            degree[i[0]]++;
            degree[i[1]]++;
        }
    }
}
