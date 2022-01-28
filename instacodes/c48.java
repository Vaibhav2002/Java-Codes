package instacodes;

import java.util.Arrays;
import java.util.Scanner;

public class c48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter difference");
        int d = sc.nextInt();
        System.out.println("Enter size of array");
        int[] a = new int[sc.nextInt()];
        System.out.println("Enter elements");
        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        int i = 0, j = 1, count = 0;
        while (i < a.length && j < a.length) {
            if (i != j && a[j] - a[i] == d) {
                count++;
                i++;
                j++;
            } else if (a[j] - a[i] > d)
                i++;
            else
                j++;
        }
        System.out.println(count);
    }
}
