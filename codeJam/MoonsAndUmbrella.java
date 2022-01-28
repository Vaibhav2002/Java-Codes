package codeJam;

import java.util.Scanner;
import java.util.Stack;

public class MoonsAndUmbrella {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseno = 0;
        while (t-- > 0) {
            caseno++;
            int x = sc.nextInt(), y = sc.nextInt();
            String s = sc.next();
            Stack<Character> st = new Stack<>();
            long ans = 0;
            char c[] = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                char ch = c[i];
                if (st.isEmpty())
                    st.push(ch);
                else {
                    if (ch == '?') {
                        if (i == c.length - 1) {
                            st.push(st.peek());
                        } else if (st.peek() == c[i + 1])
                            st.push(st.peek());
                        else {
                            if (st.peek() == 'C') {
                                if (x < y) {
                                    st.push('J');
                                    ans += x;
                                } else {
                                    st.push(st.push('C'));
                                }
                            } else {
                                if (y < x) {
                                    st.push('C');
                                    ans += y;
                                } else {
                                    st.push(st.push('J'));
                                }
                            }
                        }
                    } else {
                        if ((st.peek() + "" + ch).equals("CJ"))
                            ans += x;
                        else if ((st.peek() + "" + ch).equals("JC"))
                            ans += y;
                        st.push(ch);
                    }
                }
            }

            System.out.println("Case #" + (caseno) + ": " + (ans));
        }
    }
}
