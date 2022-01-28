package codechef;

import java.util.Scanner;

public class PatternStart {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int k=sc.nextInt();
            int c=1;
            System.out.println(c++);
            for(int i=0;i<k-2;i++){
                System.out.print(c++);
                for(int j=0;j<i;j++)
                    System.out.print(" ");
                System.out.println(c++);
            }
            if(k>1) {
                for (int i = 0; i < k; i++)
                    System.out.print(c++);
            }
            System.out.println();
        }
    }
}
