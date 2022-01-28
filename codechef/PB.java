package codechef;

import java.util.Scanner;

public class PB {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            long c=0;
            int k=sc.nextInt();
            if(k==0)
                System.out.println(0);
            else {
                for (int i = 1; i <= k; i++) {
                    if (i % 2 == 1) {
                        for (int j = 0; j < k; j++)
                            System.out.print(j % 2);
                    } else {
                        for (int j = 1; j <= k; j++)
                            System.out.print(j % 2);
                    }
                    System.out.println();
                }
            }
        }
    }
}
