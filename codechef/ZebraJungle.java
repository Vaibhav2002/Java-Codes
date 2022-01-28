package codechef;

import java.util.HashMap;
import java.util.Scanner;

public class ZebraJungle {
    public static void main(String arge[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        HashMap<Integer,Integer> hash=new HashMap<>();
        boolean found=false;
        while(t-->0)
        {
            int a=sc.nextInt(),b=sc.nextInt();
            int pos=a+b;
            if(hash.containsKey(pos)&&hash.get(pos)==a){
                found=true;
            }
            hash.put(a,pos);
        }
        System.out.println(found?"Yes":"No");
    }
}
