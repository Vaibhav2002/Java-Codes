package dsaSprint;

import java.util.*;

public class StepsByNight {

    private static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean areEqual(Position p){
            return x == p.x && y == p.y;
        }
    }

    private static class Step {
        Position pos;
        int step;

        Step(Position pos, int step) {
            this.pos = pos;
            this.step = step;
        }
    }

    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        Position knight = new Position(KnightPos[0], KnightPos[1]);
        Position target = new Position(TargetPos[0], TargetPos[1]);
        return find(knight, target, N);

    }

    private int find(Position start, Position target, int n) {
        Queue<Step> que = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][n + 1];
        que.add(new Step(start, 0));
        while (!que.isEmpty()) {
            var pos = que.poll();
            if (pos.pos.areEqual(target)) return pos.step;
            var possibleMoves = getPossiblePositions(pos.pos, n, visited);
            for (Position p : possibleMoves) {
                que.add(new Step(p, pos.step + 1));
                visited[p.x][p.y] = true;
            }
        }
        return -1;
    }

    private List<Position> getPossiblePositions(Position pos, int n, boolean[][] visited) {
        List<Position> positions = new ArrayList<Position>();
        int[] dist1 = {-1, 1};
        int[] dist2 = {-2, 2};
        for (int d : dist2) {
            for (int d1 : dist1)
                checkAndAdd(pos.x + d, pos.y + d1, n, visited, positions);
            for (int d1 : dist1)
                checkAndAdd(pos.x + d1, pos.y + d, n, visited, positions);
        }
        return positions;
    }

    private void checkAndAdd(int x, int y, int n, boolean[][] visited, List<Position> pos) {
        if (x <= n && y <= n && x > 0 && y > 0 && !visited[x][y]) pos.add(new Position(x, y));
    }

    public static void main(String[] args) {
        int n = 6;
        int[] knight = {4, 5};
        int[] target = {1, 1};
        StepsByNight ob = new StepsByNight();
        System.out.println(ob.minStepToReachTarget(knight, target, n));
    }
}
