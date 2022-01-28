package rcctechz;

import java.util.Scanner;
import java.util.Stack;

public class BracketLetter {

    public static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch))
                st.push(ch);
            else {
                if (st.isEmpty() || st.pop() - 32 != ch) return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Character> ob = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            System.out.println(check(s) ? "Y" : "N");
        }
    }
}
