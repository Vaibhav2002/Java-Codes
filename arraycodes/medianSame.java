package arraycodes;

import java.util.Scanner;

public class medianSame {
    int find_median(int a[], int b[], int sa, int sb, int ena, int enb) {
        if (ena - sa == 1)
            return (Math.max(a[sa], b[sb]) + Math.min(a[ena], b[enb])) / 2;
        int m1 = median(a, sa, ena);
        int m2 = median(b, sb, enb);
        if (m1 == m2)
            return m1;
        else if (m1 < m2)
            return find_median(a, b, (ena + sa + 1) / 2, sb, ena, (enb + sb + 1) / 2);
        else
            return find_median(a, b, sa, (enb + sb + 1) / 2, (ena + sa + 1) / 2, enb);
    }

    private int median(int[] a, int start, int end) {
        int n = end - start + 1;
        if (n % 2 == 0)
            return (a[start + n / 2] + a[start + (n / 2 - 1)]) / 2;
        else
            return a[start + n / 2];
    }

    public static void main(String[] args) {
        medianSame ob = new medianSame();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println("Enter size of 2nd array");
        int m = sc.nextInt();
        int[] b = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();
        System.out.println("Median is : " + ob.find_median(a, b, 0, 0, n - 1, m - 1));
    }
}
