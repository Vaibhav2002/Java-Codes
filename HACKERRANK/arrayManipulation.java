package HACKERRANK;

import java.util.Scanner;

public class arrayManipulation {
    // Complete the arrayManipulation function below.
    static long arraymanipulation(int n, int[][] queries) {
        long ar[] = new long[n + 2];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0], b = queries[i][1], c = queries[i][2];
            ar[a] += c;
            ar[b + 1] -= c;
        }
        long sum = 0,max=0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];
            ar[i] = sum;
            if(ar[i]>max)
                max=ar[i];
        }
        return max;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arraymanipulation(n, queries);

        System.out.println(result);
        scanner.close();
    }
}

