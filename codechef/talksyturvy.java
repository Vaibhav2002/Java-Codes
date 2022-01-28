package codechef;

import java.util.Scanner;
import java.util.StringTokenizer;

public class talksyturvy {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        StringTokenizer ob=new StringTokenizer(s);
        int c=0;
        String ans="";
        while(ob.hasMoreTokens())
        {
            ++c;
            String s1=ob.nextToken();
            if("aeiou".indexOf(s1.charAt(0))!=-1)
                ans+=s1+"d";
            else
                ans+=s1.substring(1)+s1.charAt(0)+"d";
            for(int i=0;i<c;i++)
                ans+="u";
            ans+=" ";
        }
        System.out.println(ans);
    }
}
