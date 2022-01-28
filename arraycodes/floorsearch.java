package arraycodes;

import java.util.Scanner;

public class floorsearch {
    int search(int[] a, int l, int u, int x) {
        if (l > u)
            return -1;
        if (x >= a[u])
            return u;
        int mid = (l + u) / 2;
        if (a[mid] == x)
            return mid;
        if (mid > 0 && a[mid - 1] <= x && a[mid] > x)
            return mid - 1;
        if (a[mid] < x)
            return search(a, mid + 1, u, x);
        return search(a, l, mid - 1, x);
    }

    public static void main(String[] args) {
        floorsearch ob = new floorsearch();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter size of array");
        int[] a = new int[sc.nextInt()];
        System.out.println("ENter elements");
        for (int i = 0; i < a.length; i++) a[i] = sc.nextInt();
        System.out.println("Enter value to search");
        int x = sc.nextInt();
        System.out.println(a[ob.search(a, 0, a.length - 1, x)]);
    }
}
