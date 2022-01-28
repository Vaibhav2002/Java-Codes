package codechef;

import java.util.Scanner;

public class F_H {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            int k = sc.nextInt();
            for (int i = 0; i < k/2; i++) {
                int j=0;
                for (j = 0; j < k/2-i; j++) {
                    System.out.print(" ");
                }
                for (int l = 0; l < k/2-1;l ++) {
                    System.out.print(j++);
                }
                System.out.println();
            }
            for (int i = 1; i <=k/2; i++) {
                int j=1;
                for (j = 1; j <=i; j++) {
                    System.out.print(" ");
                }
                for (int l = 0; l < k/2-1;l ++) {
                    System.out.print(j++);
                }
                System.out.println();
            }
        }
    }
}
