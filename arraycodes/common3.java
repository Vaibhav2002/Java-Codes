package arraycodes;

import java.util.Arrays;
import java.util.Scanner;

public class common3 {
    void find(int a[], int b[], int c[]) {
        int x = 0, y = 0, z = 0;
        while (x < a.length && y < b.length && z < c.length) {
            if (a[x] < b[y])
                x++;
            else if (b[y] < c[z])
                y++;
            else if (a[x] > c[z] && b[y] > c[z])
                z++;
            else {
                System.out.print(a[x] + " ");
                x++;
                y++;
                z++;
            }
        }
    }

    public static void main(String[] args) {
        common3 ob = new common3();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int a[] = new int[sc.nextInt()];
        System.out.println("Enter elements");
        for (int i = 0; i < a.length; i++) a[i] = sc.nextInt();
        System.out.println("Enter size of 2nd array");
        int b[] = new int[sc.nextInt()];
        System.out.println("Enter elements");
        for (int i = 0; i < b.length; i++) b[i] = sc.nextInt();
        System.out.println("Enter size of 3rd array");
        int c[] = new int[sc.nextInt()];
        System.out.println("Enter elements");
        for (int i = 0; i < c.length; i++) c[i] = sc.nextInt();
        System.out.println("Array 1 : " + Arrays.toString(a));
        System.out.println("Array 2 : " + Arrays.toString(b));
        System.out.println("Array 3 : " + Arrays.toString(c));
        System.out.println("Common elements are :");
        ob.find(a, b, c);
    }

}
