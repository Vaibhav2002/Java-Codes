package dsaSprint;

import java.util.HashMap;

/**
 * Very important question
 */
public class CountPairsWithSum {
    int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++)
            hash.merge(arr[i], 1, Integer::sum);
        for (int i : arr) {
            if (hash.containsKey(k - i))
                ans += hash.get(k - i);
            if(k-i == i)
                ans--;
        }
        return ans/2;
    }

    public static void main(String[] args) {
        CountPairsWithSum ob = new CountPairsWithSum();
        int[] a = {1, 5, 7, 1};
        int k = 6;
        System.out.println(ob.getPairsCount(a, a.length, k));
    }


}
