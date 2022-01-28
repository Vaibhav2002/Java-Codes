package codeJam;

import java.util.Scanner;

public class ReverseSort {
    static void reverse(int[] a, int start, int end) {
        for (int i = start; i <= (start + end) / 2; i++) {
            int temp = a[i];
            a[i] = a[end - i];
            a[end - i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseno = 0;
        while (t-- > 0) {
            caseno++;
            int ans = 0;
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) {
                int min_index = i;
                for (int j = i + 1; j < n; j++) {
                    if (a[j] < a[i] && a[j] < a[min_index])
                        min_index = j;
                }
                ans += min_index - i + 1;
                reverse(a, i, min_index);
            }
            System.out.println("Case #" + (caseno) + ": " + (ans));
        }
    }
}
