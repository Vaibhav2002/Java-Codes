package gfg.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathExists {

    private static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean areEquals(Pos p) {
            return x == p.x && y == p.y;
        }
    }

    public boolean is_Possible(int[][] grid) {
        var startPos = getPos(grid, 1);
        var targetPos = getPos(grid, 2);
        return checkUsingBFS(grid, grid.length, startPos, targetPos);
    }

    private boolean checkUsingBFS(int[][] grid, int n, Pos start, Pos dest) {
        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<Pos> que = new LinkedList<>();
        que.add(start);
        visited[start.x][start.y] = true;
        while (!que.isEmpty()) {
            var pos = que.poll();
            if (pos.areEquals(dest)) return true;
            for (Pos moves : getPossibleMoves(pos, grid, visited)) {
                que.add(moves);
                visited[moves.x][moves.y] = true;
            }
        }
        return false;
    }

    private ArrayList<Pos> getPossibleMoves(Pos p, int[][] grid, boolean visited[][]) {
        int n = grid.length;
        var possible = new ArrayList<Pos>();
        int types[] = {-1, 1};
        for (int type : types) {
            int newX = p.x + type, newY = p.y + type;
            if (validatePosition(newX, p.y, visited, grid)) possible.add(new Pos(newX, p.y));
            if (validatePosition(p.x, newY, visited, grid)) possible.add(new Pos(p.x, newY));
        }
        return possible;
    }

    private boolean validatePosition(int x, int y, boolean[][] visited, int[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid.length && !visited[x][y] && grid[x][y] != 0;
    }

    private Pos getPos(int[][] grid, int target) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++)
                if (grid[i][j] == target) return new Pos(i, j);
        }
        return null;
    }
}
