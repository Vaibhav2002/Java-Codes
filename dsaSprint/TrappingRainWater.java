package dsaSprint;

import java.util.Scanner;

public class TrappingRainWater {

    static int trappingWater(int a[], int n) {
        int[] leftMax = new int[n], rightMax = new int[n];
        leftMax[0] = -1;
        rightMax[n - 1] = -1;
        int ans = 0;
        int maxBefore = a[0], maxAfter = a[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = maxBefore;
            maxBefore = Math.max(maxBefore, a[i]);
            rightMax[n - i - 1] = maxAfter;
            maxAfter = Math.max(maxAfter, a[n - i - 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            int quantity = Math.min(leftMax[i], rightMax[i]) - a[i];
            ans += Math.max(quantity, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(trappingWater(a, n));
    }
}
