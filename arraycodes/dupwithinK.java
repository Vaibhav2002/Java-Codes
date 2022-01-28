package arraycodes;

import java.util.HashSet;
import java.util.Scanner;

public class dupwithinK {
    boolean find(int a[],int k)
    {
        HashSet<Integer> ob=new HashSet<>();
        for (int i = 0; i <a.length ; i++) {
            if(ob.contains(a[i]))
                return true;
            if(i>=k)
                ob.remove(a[i-k]);
            ob.add(a[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        dupwithinK ob=new dupwithinK();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of array elements");
        int a[] = new int[sc.nextInt()];
        System.out.println("Enter array elements");
        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();
        System.out.println("Enter value of k");
        int k=sc.nextInt();
        System.out.println(ob.find(a,k)?"Duplicate found":"Duplicate not found");
    }
}
