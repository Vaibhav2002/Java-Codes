package dsaSprint;

import java.util.Arrays;

/**
 * Dutch flag algorithm.
 * This algorithm is used to sort an array of 0,1 and 2s in linear time
 */
public class DutchFlagAlgo {

    public static void sort012(int a[], int n) {
        int l = 0, mid = 0, u = n - 1;
        int temp;
        while (mid <= u) {
            switch (a[mid]) {
                case 0:
                    temp = a[l];
                    a[l] = a[mid];
                    a[mid] = temp;
                    mid++;
                    l++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = a[u];
                    a[u] = a[mid];
                    a[mid] = temp;
                    mid++;
                    u--;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] ar = {0,2,1,2,0};
        sort012(ar,ar.length);
    }

}
