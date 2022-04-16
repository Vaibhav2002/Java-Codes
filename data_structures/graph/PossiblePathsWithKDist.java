package data_structures.graph;

import java.util.Arrays;

public class PossiblePathsWithKDist {

    public int mod = 1000000007;

    public int MinimumWalk(int[][] graph, int u, int v, int k)
    {
        int[][] dp = new int[graph.length+1][k+1];
        for(int[] i:dp) Arrays.fill(i, -1);
        return findUsingDFS(u, v, k, graph, dp);
    }

    private int findUsingDFS(int i, int target, int steps, int[][] graph, int[][] dp){
        if(steps<0) return 0;
        if(i == target && steps == 0) return 1;
        if(dp[i][steps] !=-1) return dp[i][steps]%mod;
        int sum = 0;
        for(int j = 0;j<graph[i].length;j++){
            if(graph[i][j] == 1)
                sum+=findUsingDFS(j, target, steps-1, graph, dp)%mod;
        }
        return dp[i][steps] = sum%mod;
    }

}
