package leetcode;

import leetcode.graph.DisjointSet;

import java.util.HashMap;

public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int max = r*c;
        DisjointSet ob = new DisjointSet(max);
        boolean[][] visited = new boolean[r][c];
        for(int i=0;i<r;i++)
            for(int j = 0;j<c;j++)
                if(grid[i][j]!=0) dfs(i, j, grid, visited, ob);
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0;i<max-1;i++){
            freq.merge(ob.find(i), 1, Integer::sum);
        }
        int ans = 0;
        for(Integer fre:freq.values()) ans = Math.max(ans, fre);
        return ans;
    }

    private void dfs(int x, int y, int[][] grid, boolean[][] visited, DisjointSet ob) {
        if (!isInBounds(x, y, grid) || visited[x][y] || grid[x][y] == 0) return;
        visited[x][y] = true;
        int pos = getPos(x, y, grid);
        checkAndUnion(x - 1, y, pos, grid, ob, visited);
        checkAndUnion(x + 1, y, pos, grid, ob, visited);
        checkAndUnion(x, y - 1, pos, grid, ob, visited);
        checkAndUnion(x, y + 1, pos, grid, ob, visited);
        dfs(x-1, y, grid, visited, ob);
        dfs(x+1, y, grid, visited, ob);
        dfs(x, y-1, grid, visited, ob);
        dfs(x, y+1, grid, visited, ob);
    }

    private boolean checkAndUnion(int x, int y, int oldPos, int[][] grid, DisjointSet ob, boolean[][] visited) {
        if (!visited[x][y] && grid[x][y] == 1) {
            ob.union(getPos(x, y, grid), oldPos);
            return true;
        }
        return false;
    }

    private boolean isInBounds(int x, int y, int[][] grid) {
        int r = grid.length, c = grid[0].length;
        return x >= 0 && y >= 0 && x < r && y < c;
    }

    private int getPos(int x, int y, int[][] grid) {
        int r = grid.length, c = grid[0].length;
        return r * x + y;
    }
}
