package leetcode;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length + 1][grid[0].length + 1];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0') {
                    if (find(i, j, grid, visited)) count++;
                }
            }
        }
        return count;
    }

    public boolean find(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) return true;
        if (visited[i][j]) return false;
        visited[i][j] = true;
        if (grid[i][j] == '0') return true;
        boolean top = find(i - 1, j, grid, visited);
        boolean bottom = find(i + 1, j, grid, visited);
        boolean left = find(i, j - 1, grid, visited);
        boolean right = find(i, j + 1, grid, visited);
        visited[i][j] = false;
        return top && bottom && left && right;
    }
}
