package codechef;

import java.util.Scanner;

public class SeriesStart {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        long t=sc.nextLong();
        while(t-->0)
        {
            long n=sc.nextLong();
            long start=0;
            long dif=0;
            for(int i=0;i<n;i++){
                start+=dif;
                dif++;
            }
            System.out.println(start);
        }
    }
}
