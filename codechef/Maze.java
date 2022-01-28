package codechef;

import java.util.Scanner;

public class Maze {


    public static boolean checkPath(int a[][], int r, int c){
        if(r==0&&c==0)
            return a[r][c]==0;
        if(a[r][c]==1)
            return false;
        boolean left=false,up=false;
        if(c!=0)
            left=checkPath(a,r,c-1);
        if(r!=0)
            up=checkPath(a,r-1,c);
        return left||up;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] maze = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                maze[i][j]=sc.nextInt();
            }
        }
        System.out.println(checkPath(maze,5,5)?"Yes":"No");
    }
}
