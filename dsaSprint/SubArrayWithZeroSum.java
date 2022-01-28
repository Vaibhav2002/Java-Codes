package dsaSprint;

import java.util.HashSet;
import java.util.Scanner;

public class SubArrayWithZeroSum {

    static boolean findSum(int a[], int n) {
        HashSet<Integer> sum = new HashSet<>();
        int totalSum = 0;
        for (int i : a) {
            if (i == 0||totalSum == 0)
                return true;
            totalSum += i;
            if (sum.contains(totalSum)) {
                return true;
            }
            sum.add(totalSum);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(findSum(a,n));
    }

}
