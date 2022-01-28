package codechef;

import java.util.Scanner;

public class GA {
    void fillFibo(int n, int ar[]) {
        ar[0] = 0;
        if (n == 1)
            return;
        ar[1] = 1;
        if (n == 2)
            return;
        n -= 2;
        int a = 0, b = 1, c;
        for (int i = 0; i < n; i++) {
            c = a + b;
            ar[2 + i] = c;
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        GA ob = new GA();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            ob.fillFibo(n, a);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(a[j]);
                }
                System.out.println();
            }
        }
    }
}
