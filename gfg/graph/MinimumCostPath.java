package gfg.graph;

public class MinimumCostPath {
    int[] diffs = {-1, 1};
    public int minimumCostPath(int[][] grid)
    {
        var visited = new boolean[grid.length][grid[0].length];
        return dfs(0, 0, grid, visited);
    }

    private int dfs(int x, int y, int[][] grid, boolean[][] visited){
        if(x == grid.length - 1 && y == grid[0].length) return grid[x][y];
        visited[x][y] = true;
        int ans = Integer.MAX_VALUE;
        for(int diff:diffs){
            int newX = x+diff, newY = y+diff;
            if(isPointInBounds(x, newY, grid.length, grid[0].length) && !visited[x][newY])
                ans = Math.min(ans, dfs(x, newY, grid, visited));
            if(isPointInBounds(newX, y, grid.length, grid[0].length) && !visited[newX][y])
                ans = Math.min(ans, dfs(newX, y, grid, visited));
        }
        visited[x][y] = false;
        return grid[x][y]+((ans == Integer.MAX_VALUE)? 0:ans);
    }

    private boolean isPointInBounds(int x, int y, int r, int c){
        return x>=0 && y>=0 && x<r && y<c;
    }
}
