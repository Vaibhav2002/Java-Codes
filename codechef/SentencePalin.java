package codechef;

import java.util.Scanner;

public class SentencePalin {

    public static boolean isPalin(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t-->0)
        {
            String inp=sc.nextLine();
            String s="";
            boolean isPlain=true;
            for(char c:inp.toCharArray()){
                if(Character.isDigit(c)){
                    isPlain=false;
                    break;
                }
                if(Character.isLetter(c))
                    s+=c;
            }
            s=s.toLowerCase();
            if(isPlain)
                isPlain=isPalin(s);
            System.out.println(isPlain?"YES":"NO");
        }
    }
}
