package arraycodes;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubarray0and1 {
    static int maxLen(int[] a, int n) {
        for (int i = 0; i < n; i++)
            if (a[i] == 0)
                a[i] = -1;
        long sum = 0;
        HashMap<Long, Integer> hash = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (a[i] == 0 && maxLength == 0)
                maxLength = 1;
            if (sum == 0)
                maxLength = i + 1;
            if (hash.containsKey(sum))
                maxLength = Math.max(maxLength, i - hash.get(sum));
            else
                hash.put(sum, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(maxLen(a, n));
    }
}
