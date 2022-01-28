package codechef;

import java.util.Scanner;

public class F_E {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int k=sc.nextInt();
            for (int i = 1; i <=k; i++) {
                for (int j = 0; j < k-i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <=i; j++) {
                    System.out.print(j+" ");
                }
                System.out.println();
            }

        }
    }
}
