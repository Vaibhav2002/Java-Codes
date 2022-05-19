package gfg.graph;

public class FloodFill {
    public int r, c;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        r = image.length;
        c = image[0].length;
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, newColor, visited);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int color, boolean[][] visited){
        if(visited[x][y]) return;
        visited[x][y] = true;
        if(isSameColor(x-1, y, image, image[x][y])) dfs(image, x-1, y, color, visited);
        if(isSameColor(x+1, y, image, image[x][y])) dfs(image, x+1, y, color, visited);
        if(isSameColor(x, y+1, image, image[x][y])) dfs(image, x, y+1, color, visited);
        if(isSameColor(x, y-1, image, image[x][y])) dfs(image, x, y-1, color, visited);
        image[x][y] = color;
    }

    private boolean inBounds(int x, int y){
        return x>=0 && y>=0 && x<r && y<c;
    }

    private boolean isSameColor(int x, int y, int image[][], int oldColor){
        return inBounds(x, y) &&image[x][y] == oldColor;
    }
}
