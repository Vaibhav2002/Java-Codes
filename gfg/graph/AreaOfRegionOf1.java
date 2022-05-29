package gfg.graph;

public class AreaOfRegionOf1 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int r = grid.length, c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int x, int y, char[][] grid, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] || grid[x][y] == '0') return;
        visited[x][y] = true;
        dfs(x - 1, y - 1, grid, visited);
        dfs(x - 1, y, grid, visited);
        dfs(x - 1, y + 1, grid, visited);
        dfs(x, y - 1, grid, visited);
        dfs(x, y + 1, grid, visited);
        dfs(x + 1, y - 1, grid, visited);
        dfs(x + 1, y, grid, visited);
        dfs(x + 1, y + 1, grid, visited);
    }
}
