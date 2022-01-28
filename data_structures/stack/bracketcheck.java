package data_structures.stack;

import java.util.Scanner;
import java.util.Stack;

public class bracketcheck {
    public static void main(String args[]) {
        Stack<Character> ob = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression");
        String s = sc.next();
        String c = "[{(", c1 = "]})";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ("[{()}]".indexOf(ch) != -1) {
                try {
                    if (c.indexOf(ch) != -1)
                        ob.push(ch);
                    else if (c1.indexOf(ch) != -1 && (c.indexOf(ob.pop()) != c1.indexOf(ch))) {
                        System.out.println("Illegal expression ");
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println("Illegal expression");
                    System.exit(0);
                }
            }
        }
        if (ob.empty())
            System.out.println("Legal expression");
        else
            System.out.println("Illegal expression");
    }
}
