package foobar;

import java.util.Arrays;
import java.util.Scanner;

public class PrepareTheBunnies {

    public static int ans = Integer.MAX_VALUE;

    public static int solution(int[][] map) {
        ans = Integer.MAX_VALUE;
        int[][] costs = new int[map.length][map[0].length];
        for(int[] i:costs)
            Arrays.fill(i, -1);
        find(0, 0, map, 1, false, new boolean[map.length][map[0].length], costs);
        return ans;
    }

    public static int find(int i, int j, int[][] map, int nodes, boolean hasRemoved, boolean[][] visited, int[][] costs) {
        if (i < 0 || j < 0 || i >= map.length || j >= map[0].length || visited[i][j]) return Integer.MAX_VALUE;

        if (i == map.length - 1 && j == map[0].length - 1) {
            ans = Math.min(ans, nodes);
            return nodes;
        }

        //optimization
        if (nodes > costs[i][j] && costs[i][j] != -1) return Integer.MAX_VALUE;
        else costs[i][j] = nodes;

        //optimization
        if (ans != Integer.MAX_VALUE && nodes >= ans) return Integer.MAX_VALUE;

        visited[i][j] = true;

        boolean willGoNext = map[i][j] == 0 || !hasRemoved;
        if (!willGoNext) return Integer.MAX_VALUE;

        boolean hasRemovedValue = map[i][j] == 1;

        //movements
        int min = find(i - 1, j, map, nodes + 1, hasRemovedValue, visited, costs); //top
        int left = find(i, j - 1, map, nodes + 1, hasRemovedValue, visited, costs);
        min = Math.min(min, left);
        int right = find(i, j + 1, map, nodes + 1, hasRemovedValue, visited, costs);
        min = Math.min(min, right);
        int bottom = find(i + 1, j, map, nodes + 1, hasRemovedValue, visited, costs);
        min = Math.min(min, bottom);
        visited[i][j] = false;
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

//        int[][] map = {
//                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
//                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        int[][] map2 = new int[20][20];
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 20; j++)
                map2[i][j] = 0;
        double startTime = (double) System.currentTimeMillis();
        int solution = solution(map2);
        double endTime = (double) System.currentTimeMillis();
        System.out.println(solution);
        System.out.println((endTime - startTime));
    }


}
