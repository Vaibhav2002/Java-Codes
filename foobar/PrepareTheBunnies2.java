package foobar;


import java.util.*;

public class PrepareTheBunnies2 {

    static class Point {
        int i, j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static boolean isValidPoint(int i, int j, int rows, int columns) {
        return i >= 0 && j >= 0 && i < rows && j < columns;
    }

    private static List<Point> getPossiblePoints(Point p, int rows, int columns) {
        List<Point> points = new ArrayList<>();
        if (isValidPoint(p.i - 1, p.j, rows, columns)) points.add(new Point(p.i - 1, p.j));
        if (isValidPoint(p.i + 1, p.j, rows, columns)) points.add(new Point(p.i + 1, p.j));
        if (isValidPoint(p.i, p.j - 1, rows, columns)) points.add(new Point(p.i, p.j - 1));
        if (isValidPoint(p.i, p.j + 1, rows, columns)) points.add(new Point(p.i, p.j + 1));
        return points;
    }

    private static int[][] form(int x, int y, int[][] map) {
        var board = new int[map.length][map[0].length];
        for (int[] i : board)
            Arrays.fill(i, -1);
        Queue<Point> points = new LinkedList<>();
        int rows = map.length, columns = map[0].length;
        board[x][y] = 1;
        points.add(new Point(x, y));
        while (!points.isEmpty()) {
            var currentPoint = points.poll();
            var furtherPoints = getPossiblePoints(currentPoint, rows, columns);
            for (Point p : furtherPoints) {
                if (board[p.i][p.j] != -1) continue;
                board[p.i][p.j] = board[currentPoint.i][currentPoint.j] + 1;
                if (map[p.i][p.j] != 1) points.add(p);
            }
        }
        return board;
    }

    public static int solution(int[][] map) {
        var forward = form(0, 0, map);
        var backward = form(map.length - 1, map[0].length - 1, map);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (forward[i][j] > 0 && backward[i][j] > 0)
                    min = Math.min(forward[i][j] + backward[i][j] - 1, min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter row and column");
        int[][] map = {
                {0, 1, 1, 1},
                {0, 0, 1, 0},
                {0, 1, 1, 0}
        };

        int[][] map2 = {
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        int[][] map3 = new int[20][20];
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 20; j++)
                map3[i][j] = 0;
        double startTime = (double) System.currentTimeMillis();
        int solution = solution(map);
        double endTime = (double) System.currentTimeMillis();
        System.out.println(solution);
        System.out.println((endTime - startTime));
    }
}
