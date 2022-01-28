package codechef;

import java.util.Scanner;

public class PatternDecding {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int k=sc.nextInt();
            int c=1;
            for(int i=k;i>0;i--){
                for(int j=0;j<i;j++){
                    System.out.print(c++);
                }
                System.out.println();
            }
        }
    }
}
