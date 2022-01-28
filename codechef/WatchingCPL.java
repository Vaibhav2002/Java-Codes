package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class WatchingCPL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            Long a[] = new Long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                sum += a[i];
            }
            if (sum < 2 * k)
                System.out.println(-1);
            else if (sum == 2 * k)
                System.out.println(n);
            else {
                Arrays.sort(a, (o1, o2) -> -1 * o1.compareTo(o2));
                int sum1 = 0, sum2 = 0;
                long count = 0;
                for (int j = 0; j < n; j++) {
                    if (sum1 < k) {
                        sum1 += a[j];
                        count++;
                    }
                    if (j + 1 < n && sum2 < k) {
                        sum2 += a[j + 1];
                        count++;
                    }
                    j++;
                    if (sum1 >= k && sum2 >= k) break;
                }
                if(sum1>=k&&sum2>=k)
                    System.out.println(count);
                else
                    System.out.println(-1);
            }
        }
    }
}
