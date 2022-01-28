package codechef;

import java.util.Scanner;

public class NumberWithMax1InBinaryWithinRange {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long n=sc.nextLong(),m=sc.nextLong();
            long ans=(long)(Math.log10(m)/Math.log10(2))-1;
            System.out.println(ans);
        }
    }
}
