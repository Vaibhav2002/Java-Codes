package gfg.graph;

import java.util.*;

public class SpideySense {

    private static class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isInBounds(int r, int c) {
            return x >= 0 && x < r && y >= c;
        }

        private ArrayList<Cell> getNeighbouringCells(int r, int c, boolean[][] visited, char mat[][]) {
            int[] diffs = {-1, 1};
            var cells = new ArrayList<Cell>();
            for (int diff : diffs) {
                int newX = x + diff, newY = y + diff;
                var cell1 = new Cell(newX, y);
                var cell2 = new Cell(x, newY);
                if(cell1.isInBounds(r, c) && !visited[cell1.x][cell1.y] && mat[cell1.x][cell1.y] == 'O') cells.add(cell1);
                if(cell2.isInBounds(r, c) && !visited[cell2.x][cell2.y] && mat[cell2.x][cell2.y] == 'O') cells.add(cell2);
            }
            return cells;
        }
    }

    public static int[][] findDistance(char mat[][], int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int[][] ans = new int[m][n];
        for (int[] i : ans) Arrays.fill(i, -1);
        findUsingBFS(mat, m, n, visited, ans);
        return ans;
    }

    private static void findUsingBFS(char mat[][], int m, int n, boolean[][] visited, int[][] ans) {
        Queue<Cell> que = new LinkedList<>(getListOfBombs(mat, m, n));
        int time = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                var cell = que.poll();
                if (cell == null) continue;
                ans[cell.x][cell.y] = time;
                que.addAll(getNextCells(cell, visited, mat));
            }
            time++;
        }
    }

    private static List<Cell> getNextCells(Cell cell, boolean[][] visited, char mat[][]) {
        int rows = mat.length, columns = mat[0].length;
        var neighbouring = cell.getNeighbouringCells(rows, columns, visited, mat);
        neighbouring.forEach((Cell c) -> {
            visited[c.x][c.y] = true;
        });
        return neighbouring;
    }

    private static ArrayList<Cell> getListOfBombs(char[][] mat, int r, int c) {
        var ans = new ArrayList<Cell>();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (mat[i][j] == 'B') ans.add(new Cell(i, j));
        return ans;
    }
}
