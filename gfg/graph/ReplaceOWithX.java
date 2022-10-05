package gfg.graph;

public class ReplaceOWithX {

    static int[] diff = {-1, 1};

    static char[][] fill(int n, int m, char a[][]) {
        boolean[][] visited = new boolean[n][m];
        modify(0, 0, a, visited);
        return a;
    }

    static void modify(int i, int j, char[][] a, boolean[][] visited) {
        if (!isValidPoint(i, j, a) || visited[i][j]) return;
        visited[i][j] = true;
        for (int d : diff) {
            int newX = i + d, newY = j + d;
            modify(newX, j, a, visited);
            modify(i, newY, a, visited);
        }
        boolean isSurrounded = true;
        for (int d : diff) {
            int newX = i + d, newY = j + d;
            if(inBounds(newX, j, a) && !visited[newX][j])
                isSurrounded&=(a[newX][j] == 'X');
            if(inBounds(i, newY, a) && !visited[i][newY])
                isSurrounded&=(a[i][newY] == 'X');
        }
        if(isSurrounded) a[i][j] = 'X';
    }

    static boolean isValidPoint(int i, int j, char[][] a) {
        return inBounds(i, j, a) && a[i][j] == 'O';
    }

    static boolean inBounds(int i, int j, char[][] a) {
        return i >= 0 && j >= 0 && i < a.length && j < a[0].length;
    }
}
