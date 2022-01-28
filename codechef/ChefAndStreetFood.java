package codechef;

import java.util.Scanner;

public class ChefAndStreetFood {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int maxVal = 0;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt(), p = sc.nextInt(), v = sc.nextInt();
                if (p % s == 0)
                    maxVal = Math.max(maxVal, v * (p / (s+1)));
                else
                    maxVal=Math.max(maxVal,v*(p/s));
            }
            System.out.println(maxVal);
        }
    }
}
