package arraycodes;

import java.util.Scanner;

public class notKdiv {
    int find(int a[], int k, int n) {
        int l = 0, r = n - 1, sum = 0;
        for (int i : a)
            sum += i;
        if (sum % k != 0)
            return 1;
        sum = 0;
        while (l < n && a[l] % k == 0)
            l++;
        while (r >= 0 && a[r] % k == 0)
            r--;
        if (l == n)
            return -1;
        int len = Math.max((n - 1 - l), r), count = 0;
        for (int i = 0; i < len; i++) {
            sum += a[i];
        }
        if (sum % k != 0)
            count++;
        for (int i = len; i < n; i++) {
            sum += a[i] - a[i - len];
            if (sum % k != 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        notKdiv ob = new notKdiv();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println("Enter value of k");
        int k = sc.nextInt();
        System.out.println(ob.find(a, k, n));

    }
}
