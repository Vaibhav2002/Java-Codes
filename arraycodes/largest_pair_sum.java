package arraycodes;

import java.util.Scanner;

public class largest_pair_sum {
    int find(int[] a) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > max1) {
                max2 = max1;
                max1 = i;
            } else if (i > max2)
                max2 = i;
        }
        return max1 + max2;
    }

    public static void main(String[] args) {
        largest_pair_sum ob = new largest_pair_sum();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println("Max sum pair : " + ob.find(a));
    }
}
