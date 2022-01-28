package arraycodes;

import java.util.Scanner;

public class ThirdLargest {
    void find(int a[], int n) {
        int m1, m2, m3;
        m1 = m2 = m3 = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > m1) {
                m3 = m2;
                m2 = m1;
                m1 = i;
            } else if (i > m2) {
                m3 = m2;
                m2 = i;
            } else if (i > m3)
                m3 = i;
        }
        System.out.println("3rd Largest : " + m3);
    }
    public static void main(String[] args) {
        ThirdLargest ob = new ThirdLargest();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        ob.find(a, n);
    }
}
