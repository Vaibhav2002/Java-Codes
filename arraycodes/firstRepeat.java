package arraycodes;

import java.util.HashMap;
import java.util.Scanner;

public class firstRepeat {
    int find(int a[], int n) {
        int val=Integer.MIN_VALUE;
        HashMap<Integer, Integer> ob = new HashMap<>();
        for (int i = n-1; i >=0; i--)
            if (!ob.containsKey(a[i]))
                ob.put(a[i], 1);
            else
                val = a[i];
        return  val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        firstRepeat ob = new firstRepeat();
        System.out.println("ENter size of array");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        if (ob.find(a, n) != Integer.MIN_VALUE)
            System.out.println("First repeating element is : " + ob.find(a, n));
        else
            System.out.println("No repeating element");

    }
}
