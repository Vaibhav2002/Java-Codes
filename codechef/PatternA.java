package codechef;

import java.util.Scanner;

public class PatternA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            for(int i=1;i<=k;i++){
                for(int j=1;j<=k;j++){
                    System.out.print(j+""+i);
                }
                System.out.println();
            }
        }
    }

}
