package arraycodes;

import java.util.Arrays;
import java.util.Scanner;

public class min_rot {
    int find(int[] a, int l, int u) {
        if (u < l)
            return a[0];
        if (l == u)
            return a[l];
        int mid = (l + u) / 2;
        if (mid > l && a[mid] < a[mid - 1])
            return a[mid];
        if (mid < u && a[mid] > a[mid + 1])
            return a[mid + 1];
        else if (a[mid] < a[u])
            return find(a, l, mid - 1);
        return find(a, mid + 1, u);
    }

    public static void main(String[] args) {
        min_rot ob = new min_rot();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of elements");
        int a[] = new int[sc.nextInt()];
        System.out.println("Enter elements");
        for (int i = 0; i < a.length; i++) a[i] = sc.nextInt();
        System.out.println("Original array : " + Arrays.toString(a));
        System.out.println("Minimum element is : " + ob.find(a, 0, a.length-1));
    }
}
