package codechef;

import java.util.Scanner;

public class EvenDifferences {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            long a[]=new long[n];
            int count=0;
            for(int i=0;i<n;i++){
                a[i]=sc.nextLong();
                if(a[i]%2!=0)
                    count++;
            }
            System.out.println(count);
        }
    }
}
