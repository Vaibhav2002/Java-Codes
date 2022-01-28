package codechef;

import java.util.Scanner;

public class SpaceArrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long t=sc.nextLong();
        while(t-->0){
            int n=sc.nextInt();
            long count=0;
            for(int i=1;i<=n;i++){
                int num=sc.nextInt();
                if(i>num)
                    count+=i-num;
            }
            System.out.println(count%2==0?"Second":"First");

        }
    }
}
