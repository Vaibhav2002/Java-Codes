package arraycodes;

import java.util.Scanner;

public class maxproduct {
    void find(int a[], int n) {
        if (n < 2) {
            System.out.println("No pairs found");
            return;
        }
        if (n == 2) {
            System.out.println("pair is : (" + a[0] + "," + a[1] + ")");
            return;
        }
        int n1, n2, m1, m2;
        m1 = m2 = n1 = n2 = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > m1) {
                m2 = m1;
                m1 = i;
            } else if (i > m2)
                m2 = i;
            if (i < 0 && Math.abs(i) > n1) {
                n2 = n1;
                n1 = i;
            } else if (i < 0 && Math.abs(i) > n2)
                n2 = i;
        }
        if (n1 * n2 > m1 * m2)
            System.out.println("pair is : (" + n1 + "," + n2 + ")");
        else
            System.out.println("pair is : (" + m1 + "," + m2 + ")");
    }

    public static void main(String[] args) {
        maxproduct ob = new maxproduct();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        ob.find(a, n);
    }
}
