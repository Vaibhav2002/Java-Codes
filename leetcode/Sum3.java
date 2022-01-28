package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int j = i + 1, k = a.length - 1;
            while (j < k) {
                if (a[i] + a[j] + a[k] == 0) {
                    res.add(new ArrayList<>(Arrays.asList(a[i], a[j], a[k])));
                    j++;
                    while (j < a.length && a[j - 1] == a[j])
                        j++;
                }
                else if (a[i] + a[j] + a[k] > 0)
                    k--;
                else
                    j++;
            }
        }
        return res;
    }
}
