package arraycodes;

import java.util.Scanner;

public class incdec {
    int find(int[] a, int l, int u) {
        if (l == u)
            return a[l];
        if (u == l + 1)
            return Math.max(a[l], a[u]);
        int mid = l + (u - l) / 2;
        if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1])
            return a[mid];
        else if (a[mid] > a[mid + 1] && a[mid] < a[mid - 1])
            return find(a, 0, mid - 1);
        else
            return find(a, mid + 1, u);
    }

    public static void main(String[] args) {
        incdec ob = new incdec();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println(ob.find(a, 0, n - 1));
    }
}
