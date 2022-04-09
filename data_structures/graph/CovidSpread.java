package data_structures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CovidSpread {

    private static class Ward {
        int x, y, time;

        Ward(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public int helpaterp(int[][] hospital) {
        int n = hospital.length, m = hospital[0].length;
        boolean[][] visited = new boolean[n + 1][m + 1];
        int time[][] = new int[n + 1][m + 1];
        Queue<Ward> que = new LinkedList<>();
        for (int[] i : time) Arrays.fill(i, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (hospital[i][j] == 2)
                    que.add(new Ward(i, j, 0));
        }
        checkUsingBFS(que, hospital, time, visited);
        int ans = -1;
        boolean allInfected = true;
        for (int i=0;i<time.length;i++) {
            for (int j = 0;j<time[0].length;j++) {
                if(time[i][j] == -1 && hospital[i][j] == 1){
                    allInfected = false;
                    break;
                }
                ans = Math.max(ans, time[i][j]);
            }
        }
        if(!allInfected) return -1;
        return ans;
    }

    private void checkUsingBFS(Queue<Ward> que, int[][] hospital, int[][] time, boolean[][] visited) {
        while (!que.isEmpty()) {
            var node = que.poll();
            time[node.x][node.y] = node.time;
            for (Ward next : getPossibleMoves(node, hospital, visited)) {
                visited[next.x][next.y] = true;
                que.add(next);
            }
        }
    }

    private ArrayList<Ward> getPossibleMoves(Ward ward, int[][] hospital, boolean[][] visited) {
        int[] types = {-1, 1};
        var moves = new ArrayList<Ward>();
        for (int type : types) {
            int newX = ward.x + type, newY = ward.y + type;
            if (isValidWard(newX, ward.y, hospital, visited)) moves.add(new Ward(newX, ward.y, ward.time + 1));
            if (isValidWard(ward.x, newY, hospital, visited)) moves.add(new Ward(ward.x, newY, ward.time + 1));
        }
        return moves;
    }

    private boolean isValidWard(int x, int y, int[][] hospital, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < hospital.length && y < hospital[0].length && hospital[x][y] == 1 && !visited[x][y];
    }

    public static void main(String[] args) {
        int[][] hospital = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };
        CovidSpread ob = new CovidSpread();
        System.out.println(ob.helpaterp(hospital));
    }
}
