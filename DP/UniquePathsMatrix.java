package DP;

public class UniquePathsMatrix {

    static int count = 0;

    public static int NumberOfPath(int a, int b) {
       count = 0;
       paths(a, b);
       return count;
    }

    public static void paths(int a, int b) {
        if (a == 0 || b == 0) return;
        if (a == 1 || b == 1) {
            count++;
            return;
        }
        paths(a, b - 1);
        paths(a - 1, b);
    }

}
