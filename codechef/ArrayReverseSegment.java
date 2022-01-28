package codechef;

import java.util.Scanner;

public class ArrayReverseSegment {

    public static int findFirst(long a[]) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                return i;
        return -1;
    }

    public static int findLast(long a[]) {
        for (int i = a.length - 1; i > 0; i--)
            if (a[i] < a[i - 1])
                return i;
        return -1;
    }

    public static boolean check(long a[], int l, int r) {
        while (l < r) {
            long temp = a[l];
            a[l++] = a[r];
            a[r--] = temp;
        }
        for (int i = 0; i < a.length - 1; i++)
            if (a[i + 1] < a[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();
        int first = findFirst(a);
        int last = findLast(a);
        if (check(a, first, last))
            System.out.println(++first + " " + ++last);
        else
            System.out.println("0 0");

    }
}
