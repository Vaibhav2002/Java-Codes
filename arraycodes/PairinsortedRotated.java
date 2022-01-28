package arraycodes;

import java.util.Scanner;

public class PairinsortedRotated {
    boolean find(int[] a, int n, int x) {
        int i, l, r;
        for (i = 0; i < n - 1; i++)
            if (a[i] > a[i + 1])
                break;
        l = (i + 1) % n;
        r = i;
        while (l != r) {
            if (a[l] + a[r] == x)
                return true;
            if (a[l] + a[r] > x)
                r = (n+r - 1) % n;
            else
                l = (l + 1) % n;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PairinsortedRotated ob = new PairinsortedRotated();
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println("Enter sum value");
        int x = sc.nextInt();
        if (ob.find(a, n, x))
            System.out.println("Pair found");
        else
            System.out.println("Pair not found");
    }
}
