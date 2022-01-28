package dsaSprint;

import java.util.Arrays;

public class MoveNegToStart {

    public static void moveNegToStart(int a[]) {
        int l = 0, u = a.length - 1;
        while (l < u) {
            if (a[l] < 0)
                l++;
            else if (a[u] > 0)
                u--;
            else {
                int temp = a[l];
                a[l] = a[u];
                a[u] = temp;
            }

        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        moveNegToStart(new int[]{-12, -11, -13, -5, -6, -7, -5, -3, -6});
    }
}
