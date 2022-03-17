package college;

import java.util.Scanner;

public class CodeplayQ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            if (n % 2 != m % 2)
                System.out.println(0);
            else System.out.println(1);
        }
    }
}
