package gfg.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1/?page=1&difficulty[]=1&status[]=unsolved&category[]=Graph&sortBy=submissions">Problem</a>
 */
public class ShortestSourceToDestinationPath {

    private static class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private boolean isInBounds(int r, int c) {
            return x >= 0 && y >= 0 && x < r && y < c;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Cell))
                return super.equals(obj);
            return x == ((Cell) obj).x && y == ((Cell) obj).y;
        }
    }

    int shortestDistance(int n, int m, int a[][], int x, int y) {
        if (a[0][0] == 0) return -1;
        boolean[][] visited = new boolean[n][m];
        Cell start = new Cell(0, 0), dest = new Cell(x, y);
        return findUsingBFS(start, dest, a, visited);
    }

    private int findUsingBFS(Cell start, Cell dest, int graph[][], boolean[][] visited) {
        Queue<Cell> que = new LinkedList<>();
        int count = 0;
        que.add(start);
        while (!que.isEmpty()) {
            int len = que.size();
            for(int i=0;i<len;i++){
                var node = que.poll();
                if (node.equals(dest)) return count;
                que.addAll(getNextCells(node, graph, visited));
            }
            count++;
        }
        return -1;
    }

    private ArrayList<Cell> getNextCells(Cell cell, int[][] graph, boolean[][] visited) {
        var moves = new ArrayList<Cell>();
        int[] diffs = {-1, 1};
        for (int diff : diffs) {
            int newX = cell.x + diff, newY = cell.y + diff;
            Cell cell1 = new Cell(newX, cell.y), cell2 = new Cell(cell.x, newY);
            if (isValidPoint(cell1, visited, graph)) moves.add(cell1);
            if (isValidPoint(cell2, visited, graph)) moves.add(cell2);
        }
        moves.forEach((Cell c) -> {
            visited[c.x][c.y] = true;
        });
        return moves;
    }

    private boolean isValidPoint(Cell cell, boolean[][] visited, int[][] graph) {
        return cell.isInBounds(graph.length, graph[0].length) && graph[cell.x][cell.y] == 1 && !visited[cell.x][cell.y];
    }
}
