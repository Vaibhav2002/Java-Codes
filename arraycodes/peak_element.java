package arraycodes;

import java.util.Arrays;
import java.util.Scanner;

public class peak_element {
    int find_peak(int[] a, int n, int l, int u) {
        int mid = (l + u) / 2;
        if (mid == 0 || mid == n - 1 || (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]))
            return a[mid];
        else if (a[mid - 1] < a[mid])
            return find_peak(a, n, mid + 1, u);
        else
            return find_peak(a, n, l, mid - 1);
    }

    public static void main(String[] args) {
        peak_element ob = new peak_element();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println("original array : " + Arrays.toString(a));
        System.out.println("Peak element : " + ob.find_peak(a, a.length, 0, a.length - 1));
    }
}
