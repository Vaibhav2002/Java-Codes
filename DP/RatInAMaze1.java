package DP;

import java.util.ArrayList;

public class RatInAMaze1 {

    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] visited = new boolean[n][n];
        var ans = new ArrayList<String>();
        find(m, 0, 0, "", visited, ans);
        return ans;
    }

    public static void find(int[][] maze, int i, int j, String s, boolean[][] visited, ArrayList<String> ans) {
        if (i < 0 || j < 0 || j >= maze.length || i >= maze.length || !visited[i][j])
            return;
        visited[i][j] = true;
        if (i == maze.length - 1 && j == maze.length - 1) {
            ans.add(s);
            return;
        }
        find(maze, i, j-1, s+"L", visited, ans);
        find(maze, i, j+1, s+"R", visited, ans);
        find(maze, i-1, j, s+"U", visited, ans);
        find(maze, i+1, j, s+"D", visited, ans);
    }
}
