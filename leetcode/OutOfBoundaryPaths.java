package leetcode;

public class OutOfBoundaryPaths {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        boolean[][] visited = new boolean[m][n];
        return find(startRow,startColumn,m,n,maxMove,visited);
    }

    public int find(int i, int j, int m, int n, int movesLeft, boolean[][] visited) {
        if (movesLeft < 0)
            return 0;
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 1;
        if(visited[i][j])
            return 0;
        visited[i][j] = true;
        int left = find(i, j-1, m, n , movesLeft-1, visited);
        int right = find(i, j+1, m, n , movesLeft-1, visited);
        int up = find(i-1, j, m, n , movesLeft-1, visited);
        int down = find(i+1, j, m, n , movesLeft-1, visited);
        return left+right+up+down;

    }

    public static void main(String[] args) {
        OutOfBoundaryPaths ob = new OutOfBoundaryPaths();
        System.out.println(ob.findPaths(1, 3, 3, 0, 1));
    }
}
