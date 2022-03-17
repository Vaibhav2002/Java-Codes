package college;

import java.util.Arrays;
import java.util.Scanner;

public class GDSCCP3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int sum = count(n);
            System.out.println(sum);
        }
    }

    public static int count(int n) {
        boolean[] b = new boolean[n + 1];
        Arrays.fill(b, true);
        for (int i = 2; i * i <= n; i++) {
            if (b[i]) {
                for (int j = i * i; j <= n; j += i)
                    b[j] = false;
            }
        }
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (b[i])
                sum += i;
        }
        return sum;

    }
}
