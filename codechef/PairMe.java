package codechef;

import java.util.Scanner;

public class PairMe {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            long x=sc.nextLong(),y=sc.nextLong(),z=sc.nextLong();
            boolean found=false;
            if(x==y+z)
                found=true;
            else if(y==x+z)
                found=true;
            else if(z==y+x)
                found=true;
            System.out.println(found?"YES":"NO");
        }
    }
}
