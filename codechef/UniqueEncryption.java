package codechef;

import java.util.Scanner;

public class UniqueEncryption {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[] values ={98, 57, 31, 45, 46};
        while(t-->0){
            String s=sc.next();
            String ans="";
            char[] c=s.toCharArray();
            for(int i=0;i<c.length;i++){
                int value=((c[i]-'A')+values[i])%26;
                ans+=(char)('A'+value)+"";
            }
            System.out.println(ans);
        }
    }
}
