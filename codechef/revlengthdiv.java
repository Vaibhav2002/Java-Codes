package codechef;

import java.util.Scanner;

public class revlengthdiv {
    boolean check(String s) {
        int l = s.length();
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            s1 += s.charAt(i) + "";
            if (Integer.parseInt(s1) % l-- != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        revlengthdiv ob = new revlengthdiv();
        System.out.println("Enter number");
        String s = sc.next();
        System.out.println(ob.check(s) ? "YES" : "NO");
    }
}
