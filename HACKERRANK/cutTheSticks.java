package HACKERRANK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class cutTheSticks {
    static int[] cutthesticks(int[] a) {
        ArrayList<Integer> res=new ArrayList<>();
        ArrayList<Integer> ob=new ArrayList<>();
        for(int i:a)
            ob.add(i);
        Collections.sort(ob);
        res.add(ob.size());
        while(ob.size()>1)
        {
            int x=ob.get(0);
            ob.remove(0);
            for(int i=0;i<ob.size();i++){
                ob.set(i,ob.get(i)-x);
                if(ob.get(i)==0) {
                    ob.remove(i--);
                }
            }
            if(ob.isEmpty())
                break;
            res.add(ob.size());
        }
        int ans[]=new int[res.size()];
        for(int i=0;i<res.size();i++)
            ans[i]=res.get(i);
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        a=cutthesticks(a);
        System.out.println(Arrays.toString(a));
    }
}
