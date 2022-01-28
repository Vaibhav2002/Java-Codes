package codechef;

import java.util.Scanner;

public class chefEasyQueries {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt(),k=sc.nextInt();
            int sum=0,j=0,c=0;
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            do {
                if(c<n)
                    sum+=a[c++];
                sum-=k;
                j++;
            }while(sum==0||sum>=k);
        }
    }
}
