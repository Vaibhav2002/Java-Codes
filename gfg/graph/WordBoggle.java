package gfg.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class WordBoggle {

    private static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] wordBoggle(char board[][], String[] dictionary) {
        HashSet<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n + 1][n + 1];
        var ans = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checkUsingDFS(new Pos(i, j), board, n, m,"", ans, dict, visited);
            }
        }
        String[] a = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) a[i] = ans.get(i);
        return a;
    }

    private void checkUsingDFS(Pos p, char[][] board, int n, int m, String formed, ArrayList<String> words, HashSet<String> dict, boolean[][] visited) {
        formed += board[p.x][p.y];
        if (dict.contains(formed)) words.add(formed);
        visited[p.x][p.y] = true;
        var moves = getPossibleMoves(p, board, n,m, visited);
        for (Pos move : moves) checkUsingDFS(move, board, n, m,formed, words, dict, visited);
    }

    private ArrayList<Pos> getPossibleMoves(Pos p, char board[][], int n, int m, boolean[][] visited) {
        var possible = new ArrayList<Pos>();
        int[] types = {-1, 1};
        for (int type : types) {
            int newX = p.x + type, newY = p.y + type;
            if (isValidMove(newX, p.y, n, m, visited)) possible.add(new Pos(newX, p.y));
            if (isValidMove(p.x, newY, n, m, visited)) possible.add(new Pos(p.x, newY));
            if (isValidMove(newX, newY, n, m, visited)) possible.add(new Pos(newX, newY));
        }
        if (isValidMove(p.x - 1, p.y + 1, n, m, visited)) possible.add(new Pos(p.x - 1, p.y + 1));
        if (isValidMove(p.x + 1, p.y - 1, n, m, visited)) possible.add(new Pos(p.x + 1, p.y - 1));
        return possible;
    }

    private boolean isValidMove(int x, int y, int n, int m, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < n && y < m && !visited[x][y];
    }

}
