package codechef;

import java.util.Scanner;

public class HammingDistance {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next(),s1=sc.next();
        char a[]=s.toCharArray(),b[]=s1.toCharArray();
        long count=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i])
                count++;
        }
        System.out.println(count);
    }
}
