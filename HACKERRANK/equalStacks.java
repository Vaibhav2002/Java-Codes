package HACKERRANK;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class equalStacks {
    public static int equalstacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        Stack<Integer> s3=new Stack<>();
        int sum1=0,sum2=0,sum3=0;
        for(int i=h1.size()-1;i>=0;i--)
        {
            sum1+=h1.get(i);
            s1.push(sum1);
        }
        for(int i=h2.size()-1;i>=0;i--)
        {
            sum2+=h2.get(i);
            s2.push(sum2);
        }
        for(int i=h3.size()-1;i>=0;i--)
        {
            sum3+=h3.get(i);
            s3.push(sum3);
        }
        while(true)
        {
            if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty())
                return 0;
            if(s1.peek()==s2.peek()&&s2.peek()==s3.peek())
                return s1.peek();
            else if(s1.peek()>s2.peek()&&s1.peek()>s3.peek())
                s1.pop();
            else if(s2.peek()>s1.peek()&&s2.peek()>s3.peek())
                s2.pop();
            else if(s3.peek()>s1.peek()&&s3.peek()>s2.peek())
                s3.pop();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
        List<Integer> s1=new ArrayList<>(a);
        List<Integer> s2=new ArrayList<>(b);
        List<Integer> s3=new ArrayList<>(c);
        for(int i=0;i<a;i++)
            s1.add(sc.nextInt());
        for(int i=0;i<b;i++)
            s2.add(sc.nextInt());
        for(int i=0;i<c;i++)
            s3.add(sc.nextInt());
        int res=equalstacks(s1,s2,s3);
        System.out.println(res);
    }
}
