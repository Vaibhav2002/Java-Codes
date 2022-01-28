package arraycodes;

import java.util.Scanner;

public class adj1search {
    int find(int a[], int x) {
        int i = 0;
        while (i < a.length) {
            if (a[i] == x)
                return i;
            i += Math.abs(a[i] - x);
        }
        return -1;
    }

    public static void main(String[] args) {
        adj1search ob = new adj1search();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println("Enter element to find");
        int x = sc.nextInt();
        int c = ob.find(a, x);
        if (c == -1)
            System.out.println("No element found");
        else
            System.out.println("Element found at index : " + c);
    }
}
