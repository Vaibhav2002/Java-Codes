package HACKERRANK;

import java.util.Arrays;
import java.util.Scanner;

public class permutingArrays {
    static String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < B.length / 2; i++) {
            int temp = B[i];
            B[i] = B[B.length - i - 1];
            B[B.length - i - 1] = temp;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] + B[i] < k)
                return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        int[] a=new int[n],b=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            b[i]=sc.nextInt();
        System.out.println(twoArrays(k,a,b));

    }
}
