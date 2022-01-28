package codechef;

import java.util.Scanner;
import java.util.Stack;

public class REMOVE_IT {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            String s1="";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='c'&&s1.length()>=2 ){
                    if(s1.charAt(s1.length()-1)=='b'&&s1.charAt(s1.length()-2)=='a')
                        s1=s1.substring(0,s1.length()-2);
                    else
                        s1+=s.charAt(i);
                }
                else
                    s1+=s.charAt(i);
            }
            System.out.println(s1);
        }
    }
}
