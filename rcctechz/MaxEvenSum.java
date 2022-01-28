package rcctechz;

import java.util.Scanner;

public class MaxEvenSum {

    public static boolean isEven(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) sum += i;
        return sum % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (isEven(0, n)) System.out.println(n);
        else {
            int maxIndex = 0, sum =0;
            for (int i = 0; i <= n; i++) {
                sum += i;
                if (sum % 2 == 0)
                    maxIndex = i;
            }
            System.out.println(maxIndex);
        }
    }
}
