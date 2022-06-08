package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
* <a href="https://leetcode.com/problems/k-closest-points-to-origin/">Problem</a>
**/
public class KClosestPointsToOrigin {

    private static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        int calcDistance(){
            int xSide = (int)Math.pow(x, 2);
            int ySide = (int)Math.pow(y, 2);
            return (int)Math.sqrt(xSide+ySide);
        }

        boolean isCloser(Point p){
            return calcDistance()<p.calcDistance();
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        var pq = new PriorityQueue<>(k, (Point p1, Point p2)->Integer.compare(p2.calcDistance(), p1.calcDistance()));
        for(int[] i:points){
            var curr = new Point(i[0], i[1]);
            pq.add(curr);
            if(pq.size() > k) pq.poll();
        }
        var ans = new int[pq.size()][2];
        int index = 0;
        while(!pq.isEmpty()){
            var point = pq.poll();
            ans[index][0] = point.x;
            ans[index][1] = point.y;
            index++;
        }
        return ans;
    }
}
