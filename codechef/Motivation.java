package codechef;

import java.util.HashMap;
import java.util.Scanner;

public class Motivation {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            long n=sc.nextLong(),x=sc.nextLong();
            long ans=0,max_r=0;
            for(int i=0;i<n;i++){
                long s=sc.nextLong(),r=sc.nextLong();
                if (r > max_r && s <= x) {
                    max_r=r;
                    ans=r;
                }
            }
            System.out.println(ans);
        }
    }
}
