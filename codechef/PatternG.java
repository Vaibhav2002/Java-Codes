package codechef;

import java.util.Scanner;

public class PatternG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            for(int i=1;i<=k;i++){
                for(int j=0;j<k-i;j++)
                    System.out.print(" ");
                for(int j=1;j<=2*i-1;j++){
                    System.out.print("*");
                }
                System.out.println();
                for(int j=0;j<k-i;j++)
                    System.out.print(" ");
                for(int j=1;j<=2*i-1;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
