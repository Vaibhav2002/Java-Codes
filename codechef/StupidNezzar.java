package codechef;

import java.util.Scanner;

public class StupidNezzar {
    static void print(long[] a,long b[]){
        long[] sum=new long[b.length];
        long s=0;
        for(int i=0;i<b.length;i++){
            s+=b[i];
            sum[i]=s;
        }
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]+sum[i] + " ");
        System.out.println();

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long[] a =new long[n];
            long b[]=new long[n+1];
            for (int i = 0; i < n; i++)
                a[i]=sc.nextLong();
            int q=sc.nextInt();
            while(q-->0){
                String u=sc.next();
                if(u.equals("U")){
                    print(a,b);
                }
                else{
                    int l=Integer.parseInt(u);
                    int r=sc.nextInt();
                    long x=sc.nextLong();
                    b[l-1]+=x;
                    b[r]-=x;
                }
            }
        }
    }
}
