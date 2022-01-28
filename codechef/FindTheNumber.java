package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long[] a =new long[n];
            for (int i = 0; i < n; i++)
                a[i]=sc.nextLong();
            Arrays.sort(a);
            long prod = a[0] * a[a.length - 1];
            if(n%2==0)
                System.out.println(prod);
            else{
                if(prod ==a[a.length/2]*a[a.length/2])
                    System.out.println(prod);
                else
                    System.out.println(-1);
            }
        }
    }
}
