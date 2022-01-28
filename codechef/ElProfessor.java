package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class ElProfessor {

    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int ar[] = new int[n];
            Arrays.fill(ar, 10);
            while (m-- > 0) {
                int a = sc.nextInt(), b = sc.nextInt(), k = sc.nextInt();
                for(int i=a-1;i<b;i++)
                    ar[i]=ar[i]*k;
            }
            int sum=0;
            for(int i:ar)
                sum+=i;
            System.out.println(sum/n);
        }
    }

}
