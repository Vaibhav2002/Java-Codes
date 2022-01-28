package codechef;

import java.util.Scanner;

public class CollegeLife2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            long ans=0;
            int s = sc.nextInt();
            long[] q = new long[s];
            for (int i = 0; i < s; i++)
                q[i] = sc.nextLong();
            for (int i = 0; i < s; i++) {
                long e = sc.nextLong();
                long sum = 0;
                for (int j = 0; j < e; j++)
                    sum += sc.nextLong();
                ans+=sum-(e-1)*q[i];
            }
            System.out.println(ans);
        }
    }
}
