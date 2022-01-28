package codechef;

import java.util.Scanner;

public class SquareStart {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            n--;
            long ans=(n*(n+1)*(2*n+1))/3;
            n++;
            ans+=n*n;
            System.out.println(ans);
        }

    }
}
