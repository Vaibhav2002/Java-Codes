package arraycodes;

import java.util.Arrays;
import java.util.Scanner;

public class diffpair {
    String find(int a[],int n, int x)
    {
        int l=0,r=1;
        while(l<a.length&&r<a.length)
        {
            if(l!=r&&a[r]-a[l]==x)
                return "Pair Found ("+a[l]+","+a[r]+")";
            else if(a[r]-a[l]>x)
                l++;
            else
                r++;
        }
        return "No pair found";
    }

    public static void main(String[] args) {
        diffpair ob=new diffpair();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println("Enter diff value");
        int x = sc.nextInt();
        Arrays.sort(a);
        System.out.println(ob.find(a,n-1,x));
    }
}
