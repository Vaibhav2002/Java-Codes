package codechef;

import java.util.Scanner;

/**
 * <a href="https://www.codechef.com/problems/ANUARM">CodeChef Problem</a>
 */
public class TheArmy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            boolean[] selected = new boolean[n];
            for (int i = 0; i < m; i++) selected[sc.nextInt()] = true;
            int[] left = new int[n], right = new int[n];
            int distant = -1;
            for (int i = 0; i < n; i++) {
                if (selected[i] && distant == -1) distant = i;
                left[i] = distant;
            }
            distant = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (selected[i] && distant == -1) distant = i;
                right[i] = distant;
            }
            for (int i = 0; i < n; i++) {
                int ans = 0;
                if (left[i] != -1 && right[i] != -1)
                    ans = Math.max(i - left[i], right[i] - i);
                else if (left[i] != -1) ans = i - left[i];
                else if (right[i] != -1) ans = right[i] - i;
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }


}
