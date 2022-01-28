package stringcodes;

import java.util.Scanner;

public class AdjacentRemoveRecursive {

    static String find(String ans,String s){
        if(s.equals(""))
            return ans;
        if(ans.charAt(ans.length()-1)==s.charAt(0))
            return find(ans,s.substring(1));
        else return find(ans+s.charAt(0),s.substring(1));
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            String ans=find(" ",s);
            System.out.println(ans.trim());
        }
    }
}
