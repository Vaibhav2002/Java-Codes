package leetcode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class seqEqn {
    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p, int n) {
        int ans[] = new int[n];
        int c = 0;
        for (int i = 1; i <= n; i++) {
            int a = Arrays.binarySearch(p, i) + 1;
            a = Arrays.binarySearch(p, a) + 1;
            ans[c++] = a;
        }
        return ans;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        int n = scanner.nextInt();
        int[] p = new int[n];
        for(int i=0;i<n;i++)
            p[i]= scanner.nextInt();
        int[] result = permutationEquation(p, n);

        for (int j : result)
            System.out.print(j + " ");
        scanner.close();
    }
}

