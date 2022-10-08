package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
* <a href="https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/">Problem</a>
**/
public class NumberOfPointsInsideCircle {

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

       int calcDistance(Point p){
            return (int)Math.ceil(Math.sqrt(sqr(x - p.x) + sqr(y - p.y)));
       }

       int sqr(int a){
            return a*a;
       }

    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        var p = new ArrayList<Point>();
        for(int[] i:points) p.add(new Point(i[0], i[1]));
        for(int i = 0;i< queries.length;i++){
            var center = new Point(queries[i][0], queries[i][1]);
            int radius = queries[i][2];
            for(Point point:p)
                if(point.calcDistance(center) <= radius) ans[i]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {
                {1, 3},
                {3, 3},
                {5, 3},
                {2, 2}
        };
        int[][] queries = {
                {2, 3, 1},
                {4, 3, 1},
                {1, 1, 2}
        };
        int[] dist = new NumberOfPointsInsideCircle().countPoints(points, queries);
        System.out.println(Arrays.toString(dist));
    }

}
