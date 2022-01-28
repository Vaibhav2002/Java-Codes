package foobar;

import java.util.ArrayList;
import java.util.List;

public class DontGetVolunteered {

    static class Pos {
        int row, column;

        Pos(int row, int column) {
            this.row = row;
            this.column = column;
        }

        Pos(int x) {
            this(x / 8, x % 8);
        }

        boolean isValid() {
            return row >= 0 && row < 8 && column >= 0 && column < 8;
        }

        boolean isSamePos(Pos x) {
            return this.row == x.row && this.column == x.column;
        }
    }

    static int min = Integer.MAX_VALUE;

    public static int solution(int src, int dest) {
        if (src == dest) return 0;
        min = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[8][8];
        Pos startPos = new Pos(src);
        Pos destPos = new Pos(dest);
        return find(startPos, destPos, 0, visited);
    }

    public static List<Pos> getAllMoves(Pos x) {
        List<Pos> allMoves = new ArrayList<>();
        //top
        allMoves.add(new Pos(x.row - 2, x.column - 1));
        allMoves.add(new Pos(x.row - 2, x.column + 1));
        //bottom
        allMoves.add(new Pos(x.row + 2, x.column - 1));
        allMoves.add(new Pos(x.row + 2, x.column + 1));
        //left
        allMoves.add(new Pos(x.row - 1, x.column - 2));
        allMoves.add(new Pos(x.row + 1, x.column - 2));
        //right
        allMoves.add(new Pos(x.row - 1, x.column + 2));
        allMoves.add(new Pos(x.row + 1, x.column + 2));
        return allMoves;
    }

    public static List<Pos> getValidMoves(Pos x, boolean[][] visited) {
        List<Pos> allMoves = getAllMoves(x);
        List<Pos> validMoves = new ArrayList<>();
        for (Pos p : allMoves) {
            if (p.isValid() && !visited[p.row][p.column]) validMoves.add(p);
        }
        return validMoves;
    }

    public static int find(Pos pos, Pos dest, int moves, boolean[][] visited) {
        visited[pos.row][pos.column] = true;
        List<Pos> validMoves = getValidMoves(pos, visited);
        List<Pos> nextSetOfMoves = new ArrayList<>();
        while (true) {
            moves++;
            for (Pos p : validMoves) {
                if (p.isSamePos(dest)) return moves;
                nextSetOfMoves.addAll(getValidMoves(p, visited));
            }
            validMoves.clear();
            validMoves.addAll(nextSetOfMoves);
            nextSetOfMoves.clear();
        }

    }

    public static void main(String[] args) {
        System.out.println(solution(0, 1));
    }
}
