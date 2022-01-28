package codechef;

import java.util.Scanner;

public class PatternRevisit {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k=sc.nextInt();
            int half=k/2;
            for(int i=0;i<half;i++){
                for(int j=0;j<i;j++)
                    System.out.print(" ");
                System.out.println("*");
            }
            for(int i=0;i<half;i++)
                System.out.print(" ");
            System.out.println("*");
            for(int i=half;i>0;i--){
                for(int j=1;j<i;j++)
                    System.out.print(" ");
                System.out.println("*");
            }
        }
    }
}
