package data_structures.stack;

import java.util.*;

public class MaxAreaHistogram {

    private static long[] getLeftMin(long a[], int n) {
        long[] ans = new long[(int) n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            long leftMin = -1;
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
            if (!st.isEmpty()) leftMin = st.peek();
            ans[i] = leftMin;
            st.push(i);
        }
        return ans;
    }

    private static long[] getRightMin(long a[], int n) {
        long[] ans = new long[(int) n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            long rightMin = n;
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
            if (!st.isEmpty()) rightMin = st.peek();
            ans[i] = rightMin;
            st.push(i);
        }
        return ans;
    }

    public static long getMaxArea(long hist[], long n) {
        long[] leftMin = getLeftMin(hist, (int) n);
        long[] rightMin = getRightMin(hist, (int) n);
        long ans = 0;
        for (int i = 0; i < (int) n; i++) {
            long area = rightMin[i] - leftMin[i] - 1;
            ans = Math.max(ans, hist[i] * area);
        }
        return ans;
    }

    public static void main(String[] args) {
        long hist[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(getMaxArea(hist, hist.length));
    }
}
