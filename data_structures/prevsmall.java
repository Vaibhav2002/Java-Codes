package data_structures;

import java.util.Scanner;
import java.util.Stack;

public class prevsmall {
    void print(int[] a) {
        Stack<Integer> ob = new Stack<>();
        for (int i : a) {
            while (!ob.isEmpty() && ob.peek() >= i)
                ob.pop();
            if (ob.isEmpty())
                System.out.print("_,");
            else
                System.out.print(ob.peek() + ",");
            ob.push(i);
        }
    }

    public static void main(String[] args) {
        prevsmall ob = new prevsmall();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        ob.print(a);
    }
}
