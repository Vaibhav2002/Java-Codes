package codechef;

import java.util.Scanner;

public class ValidMobileNumber {
    static boolean isValid(String s) {
        if (s.length() != 10)
            return false;
        if (s.charAt(0) == '0')
            return false;
        try {
            int n = Integer.parseInt(s);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            System.out.println(isValid(s) ? "YES" : "NO");
        }
    }
}
