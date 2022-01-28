package stringcodes;

import java.util.Scanner;

public class palin {
    boolean check(String s1) {
        for (int i = 0; i < s1.length() / 2; i++)
            if (s1.charAt(i) != s1.charAt(s1.length() - i - 1))
                return false;
        return true;
    }

    String reverse(String s) {
        String s1 = "";
        for (int i = 0; i < s.length(); i++)
            s1 = s.charAt(i) + s1;
        return s1;
    }

    public static void main(String args[]) {
        palin ob = new palin();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            if (ob.check(s)) {
                System.out.println("0");
                continue;
            }
            int l = s.length();
            for (int i = 1; i < l; i++) {
                String s1 = s.substring(0, i);
                s1 = ob.reverse(s1);
                if (ob.check(s + s1)) {
                    System.out.println(i);
                    break;
                }
            }
        }
        sc.close();
    }
}