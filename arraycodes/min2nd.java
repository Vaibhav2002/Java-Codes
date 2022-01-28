package arraycodes;

import java.util.Arrays;
import java.util.Scanner;

public class min2nd {
    int min,min2;

    public min2nd() {
        this.min = 0;
        this.min2 = 0;
    }
    void find(int a[])
    {
        if(a.length==2)
        {
            min= Math.min(a[0], a[1]);
            min2=(min==a[0])?a[1]:a[0];
            return;
        }
        int b[]=new int[(a.length%2==0)?a.length/2:a.length/2+1];
        for (int i = 1,c=0; i < a.length; i+=2,c++) {
            b[c]=Math.min(a[i],a[i-1]);
        }
        if(a.length%2!=0)
            b[b.length-1]=a[a.length-1];
        find(b);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        min2nd ob=new min2nd();
        System.out.println("ENter size of array");
        int a[]=new int[sc.nextInt()];
        System.out.println("Enter elements");
        for (int i = 0; i < a.length; i++) {
            a[i]=sc.nextInt();
        }
        System.out.println("Original array : "+ Arrays.toString(a));
        ob.find(a);
        System.out.println("Minimum = "+ob.min+"\n"+"2nd minimum = "+ob.min2);
    }
}
