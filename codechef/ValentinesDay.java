package codechef;

import java.util.Scanner;

public class ValentinesDay {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            for (int i = 0; i < n; i++)
                a[i]=sc.nextInt();
            long currMax=a[0],max=currMax;
            for (int i = 1; i < n; i++) {
                currMax=Math.max(a[i],currMax+a[i]);
                max=Math.max(currMax,max);
            }
            System.out.println(max);
        }
    }
}
