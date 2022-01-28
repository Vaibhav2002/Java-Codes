package codechef;

import java.util.Scanner;

public class PatternE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String s = "";
            for (int i = 1; i <= k; i++)
                s += Integer.toString(i);
            for (int i = 0; i < k; i++) {
                System.out.print(s.substring(i));
                System.out.println(s.substring(0, i));

            }
        }
    }
}
