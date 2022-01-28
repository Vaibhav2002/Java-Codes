package dsaSprint;

import java.util.Arrays;

public class InversionPoint {


    static long inversionCount(long arr[], long N) {
        return sort(arr);
    }

    static int sort(long a[]) {
        if (a.length == 1)
            return 0;
        long[] left = Arrays.copyOfRange(a, 0, a.length / 2);
        long[] right = Arrays.copyOfRange(a, a.length / 2, a.length);
        int leftCount = sort(left);
        int rightCount = sort(right);
        long[] sorted = new long[a.length];
        return leftCount + rightCount + merge(left, right, sorted);
    }

    static int merge(long[] a, long[] b, long[] c) {
        int i = 0, j = 0, k = 0;
        int count = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j])
                c[k++] = a[i++];
            else {
                count += a.length-i;
                c[k++] = b[j++];
            }

        }
        while (i < a.length)
            c[k++] = a[i++];
        while (j < b.length)
            c[k++] = b[j++];
        return count;
    }

    public static void main(String[] args) {
        long a[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(a, a.length));
    }
}
