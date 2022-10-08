package leetcode;

import java.util.Arrays;

/**
* <a href="https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/">Problem</a>
**/
public class WidestVerticalArea {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xCords = new int[points.length];
        for(int i = 0;i<points.length;i++) xCords[i] = points[i][0];
        Arrays.sort(xCords);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0;i< points.length - 1;i++){
            minDiff = Math.min(minDiff, xCords[i+1] - xCords[i]);
        }
        return minDiff;
    }
}
