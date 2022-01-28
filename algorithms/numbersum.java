package algorithms;

import java.util.Scanner;

public class numbersum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value");
        int n = sc.nextInt();
        int start = 1, end = 1, sum = 1;
        while (start <= n / 2) {
            if (sum < n) {
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                for (int i = start; i <= end; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                sum -= start;
                start++;
            }
        }
    }
}
