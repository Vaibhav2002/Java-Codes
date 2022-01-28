package stringcodes;

import java.util.Scanner;
import java.util.Stack;

public class ConsecutiveRemove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == c)
                st.pop();
            else
                st.push(c);
        }
        if(st.isEmpty())
            System.out.println("Empty string");
        else{
            for(char c:st)
                System.out.print(c);
        }
    }
}
