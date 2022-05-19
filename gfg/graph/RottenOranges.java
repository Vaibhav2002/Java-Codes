package gfg.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {

    private static class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int time = -1;
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Cell> oranges = new LinkedList<>(findRotten(grid, n, m));
        while (!oranges.isEmpty()) {
            time++;
            int count = oranges.size();
            for (int i = 0; i < count; i++) {
                var cell = oranges.poll();
                if (cell != null && !visited[cell.x][cell.y]) {
                    oranges.addAll(getNeighbours(cell, grid, visited));
                    visited[cell.x][cell.y] = true;
                }
            }
        }
        return time;
    }

    private ArrayList<Cell> getNeighbours(Cell cell, int[][] grid, boolean[][] visited) {
        var neighbours = new ArrayList<Cell>();
        Cell top = new Cell(cell.x - 1, cell.y), bottom = new Cell(cell.x + 1, cell.y);
        Cell left = new Cell(cell.x, cell.y - 1), right = new Cell(cell.x, cell.y + 1);
        if (isFreshOrange(top, grid, visited)) neighbours.add(top);
        if (isFreshOrange(bottom, grid, visited)) neighbours.add(bottom);
        if (isFreshOrange(left, grid, visited)) neighbours.add(left);
        if (isFreshOrange(right, grid, visited)) neighbours.add(right);
        neighbours.forEach((Cell c) -> visited[c.x][c.y] = true);
        return neighbours;
    }

    private ArrayList<Cell> findRotten(int[][] grid, int n, int m) {
        var rotten = new ArrayList<Cell>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) if (grid[i][j] == 2) rotten.add(new Cell(i, j));
        }
        return rotten;
    }

    private boolean isFreshOrange(Cell cell, int[][] grid, boolean[][] visited) {
        return inBounds(cell, grid.length, grid[0].length) && grid[cell.x][cell.y] == 1 && !visited[cell.x][cell.y];
    }

    private boolean inBounds(Cell cell, int n, int m) {
        return cell.x >= 0 && cell.y >= 0 && cell.x < n && cell.y < m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        RottenOranges ob = new RottenOranges();
        System.out.println(ob.orangesRotting(grid));
    }
}
