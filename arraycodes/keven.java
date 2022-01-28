package arraycodes;

import java.util.Scanner;

public class keven {
    int find(int a[], int k) {
        if (k % 2 != 0 || k > a.length)
            return 0;
        int count = 0, start = 0, currXor = a[0];
        for (int i = 1; i < k; i++) currXor ^= a[i];
        if (currXor == 0)
            count++;
        currXor ^= a[start++];
        for (int i = k; i < a.length; i++) {
            currXor ^= a[i];
            if (currXor == 0)
                count++;
            currXor ^= a[start];
            start++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        keven ob = new keven();
        System.out.println("Enter size of array");
        int[] a = new int[sc.nextInt()];
        System.out.println("Enter elements");
        for (int i = 0; i < a.length; i++) a[i] = sc.nextInt();
        System.out.println("Enter value of k");
        int k = sc.nextInt();
        System.out.println("No. of subsequences : " + ob.find(a, k));
    }
}
