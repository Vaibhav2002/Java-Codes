package leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String nulllines="";
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<ArrayList<Integer>> ob=new ArrayList<>();
        for(int i=0;i<n;i++)
            ob.add(i,new ArrayList<Integer>());
        for(int i=0;i<n;i++)
        {
            int g=sc.nextInt();
            for(int k=0;k<g;k++)
            {
                ob.get(i).add(sc.nextInt());
            }
        }
        int q=sc.nextInt();
        for(int i=0;i<q;i++)
        {
            int x=sc.nextInt(),y=sc.nextInt();
            if(ob.get(x-1).isEmpty()||ob.get(x-1).size()<y)
                System.out.println("ERROR: ");
            else
                System.out.println(ob.get(x-1).get(y-1));
        }
    }
}
