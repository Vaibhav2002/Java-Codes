package dsaSprint;

public class MinimizeHeight2 {
    static int getMinDiff(int[] arr, int n, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] - k > 0)
                arr[i] -= k;
            else
                arr[i] += k;
            max = Math.max(arr[i],max);
            min = Math.min(arr[i],min);

        }
        return max-min;
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 12, 16, 20};
        int k = 3;
        System.out.println(getMinDiff(arr, arr.length, k));
    }

}
