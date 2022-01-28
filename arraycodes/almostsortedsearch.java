package arraycodes;

import java.util.Scanner;

public class almostsortedsearch {
    int search(int[] a, int l, int u, int x) {
        if (l <= u) {
            int mid = l + (u - l) / 2;
            if (a[mid] == x)
                return mid;
            else if (mid > l && a[mid - 1] == x)
                return mid - 1;
            else if (mid < u && a[mid + 1] == x)
                return mid + 1;
            else if (x > a[mid])
                return search(a, mid + 1, u, x);
            else
                return search(a, l, mid - 1, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        almostsortedsearch ob = new almostsortedsearch();
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println("Enter element to search");
        int x = sc.nextInt();
        System.out.println("Element found at index " + ob.search(a, 0, n - 1, x));
    }
}
