package codechef;

import java.util.Scanner;
import java.util.Stack;

public class ColoredPens {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            String s=sc.next();
            Stack<Character> st=new Stack<>();
            for(char c:s.toCharArray()){
                if(!st.isEmpty()&&st.peek()==c)
                    st.pop();
                st.push(c);
            }
            System.out.println(s.length()-st.size());
        }
    }
}
