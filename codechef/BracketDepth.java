package codechef;

import java.util.Scanner;
import java.util.Stack;

public class BracketDepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Character> st = new Stack<>();
        int maxDepth = 0, firstPos = 0, maxLength = 0, firstLengthPos = 0, maxFirstLengthPos = 0;
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            if (x == 1) {
                if (st.isEmpty())
                    firstLengthPos = i;
                st.push('(');
                if (st.size() > maxDepth) {
                    maxDepth = st.size();
                    firstPos = i;
                }
            } else {
                st.pop();
                if (st.isEmpty()) {
                    if (i - firstLengthPos + 1 > maxLength)
                        maxFirstLengthPos = firstLengthPos;

                    maxLength = Math.max(i - firstLengthPos + 1, maxLength);
                }

            }
        }
        System.out.println(maxDepth + " " + firstPos + " " + maxLength + " " + maxFirstLengthPos);

    }
}
