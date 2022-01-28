package arraycodes;

import java.util.Scanner;

public class SumSubarray {
    static int findmax(int[] a, int n) {
        int max = a[0], ans = a[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(a[i], max + a[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }

    static int findMin(int a[], int n) {
        int min = a[0], ans = a[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(a[i], min + a[i]);
            ans = Math.min(ans, min);
        }
        return ans;
    }

    static int findMaxCircular(int a[], int n) {
        int sum = a[0];
        int min = a[0], ans = a[0];
        for (int i = 1; i < n; i++) {
            sum += a[i];
            min = Math.min(a[i], min + a[i]);
            ans = Math.min(ans, min);
        }
        return sum = min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(findmax(a, n));
        System.out.println(findMin(a, n));
        System.out.println(findMaxCircular(a, n));

    }
}
