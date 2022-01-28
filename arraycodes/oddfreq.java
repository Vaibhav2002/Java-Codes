package arraycodes;

import java.util.Scanner;

public class oddfreq {
    int find(int a[], int l, int u) {
        if (l > u)
            return -1;
        if (l == u)
            return a[l];
        int mid = l + (u - l) / 2;
        if (mid % 2 == 0) {
            if (a[mid] == a[mid + 1])
                return find(a, mid + 2, u);
            else
                return find(a, l, mid);
        } else {
            if (a[mid] == a[mid - 1])
                return find(a, mid + 1, u);
            else
                return find(a, l, mid - 1);
        }
    }

    public static void main(String[] args) {
        oddfreq ob = new oddfreq();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int c = ob.find(a, 0, n - 1);
        if (c == -1)
            System.out.println("No element found");
        else
            System.out.println("Element found : " + c);
    }
}
