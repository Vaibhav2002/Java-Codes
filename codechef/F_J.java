package codechef;

import java.util.Scanner;

public class F_J {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k=sc.nextInt();
            int c=1;
            for(int i=k/2;i>0;i--){
                for(int j=0;j<i;j++)
                    System.out.print(" ");
                for(int j=0;j<k/2-1;j++)
                    System.out.print(c);
                System.out.println();
                c++;
            }
            for(int j=0;j<k/2-1;j++)
                System.out.print(c);
            System.out.println();
            c++;
            for(int i=1;i<=k/2;i++){
                for(int j=0;j<i;j++)
                    System.out.print(" ");
                for(int j=0;j<k/2-1;j++)
                    System.out.print(c);
                System.out.println();
                c++;
            }

        }
    }
}
