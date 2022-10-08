package leetcode;

/**
* <a href="https://leetcode.com/problems/subrectangle-queries/">Problem</a>
**/
public class SubRectangleQueries {

    int[][] a;
    int r, c;

    public SubRectangleQueries(int[][] rectangle) {
        a = rectangle;
        r = rectangle.length;
        c = rectangle[0].length;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i = row1; i<=row2;i++){
            for(int j = col1;j<=col2;j++)
                a[i][j] = newValue;
        }
    }

    public int getValue(int row, int col) {
        return a[row][col];
    }
}
