package arraycodes;

import java.util.Arrays;
import java.util.Scanner;

public class fixed_index_value {
    int find(int[] a, int l, int u) {
        if (l > u)
            return -1;
        int mid = (l + u) / 2;
        if (a[mid] == mid)
            return a[mid];
        if (a[mid] > mid)
            return find(a, l, mid - 1);
        return find(a, mid + 1, u);
    }

    public static void main(String[] args) {
        fixed_index_value ob = new fixed_index_value();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of elements");
        int a[] = new int[sc.nextInt()];
        System.out.println("Enter elements");
        for (int i = 0; i < a.length; i++) a[i] = sc.nextInt();
        System.out.println("Original array : " + Arrays.toString(a));
        System.out.println("Fixed element is : " + ob.find(a, 0, a.length - 1));
    }
}
