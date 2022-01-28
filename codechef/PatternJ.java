package codechef;

import java.util.Scanner;

public class PatternJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String s;
            long c=1;
            for (int i=1;i<=k;i++){
                s="";
                for(int j=1;j<=i;j++) {
                    s = c + s;
                    c++;
                }
                System.out.println(s);
            }
        }
    }
}
