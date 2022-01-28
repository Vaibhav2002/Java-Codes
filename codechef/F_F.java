package codechef;

import java.util.Scanner;

public class F_F {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int k=sc.nextInt();
            int a[][]=new int[k*2-1][k*2-1];
            for (int i = 0; i < k; i++) {
                for (int j = i; j < a.length-i; j++) {
                    a[j][i]=k-i;
                    a[i][j]=k-i;
                    a[a.length-i-1][j]=k-i;
                    a[j][a.length-i-1]=k-i;
                }
            }
            for (int[] i : a) {
                for (int j : i) {
                    System.out.print(j);
                }
                System.out.println();
            }
        }
    }
}
