package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalMovement {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt(), y= sc.nextInt();
            int dp[][] = new int[y+1][x+1];
            for(int[] a:dp)
                Arrays.fill(a, -1);
            boolean possible = isPossible(x, y, dp);
            System.out.println(possible?"YES":"NO");
        }
    }

    public static boolean isPossible(int x, int y, int[][] dp){
        if(x == 0 && y == 0) return true;
        if(x<0 || y< 0) return false;
        if(dp[y][x]!=-1) return dp[y][x] == 1;
        boolean diagBottomLeft = isPossible(x-1, y-1, dp);
        if(diagBottomLeft){
            dp[y][x] = 1;
            return true;
        }
        boolean diagBottomRight = isPossible(x+1, y-1, dp);
        dp[y][x] = diagBottomRight?1:0;
        return diagBottomRight;
    }
}
