package codechef;

import java.util.Scanner;

public class Lockdown {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int l=sc.nextInt(),b=sc.nextInt();
            int area=l*b;
            long ans=0;
            for(int i=1;i*i<=area;i++){
                if(area%i==0)
                {
                    int val1=i*i;
                    int val2=(area/i)*(area/i);
                    if(area%val1==0)
                        ans=area/val1;
                    if(area%val2==0)
                        ans=area/val1;
                }
            }
            System.out.println(ans);
        }
    }
}
