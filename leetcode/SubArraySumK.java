package leetcode;

import java.util.HashMap;

public class SubArraySumK {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            if (sum == k || num == k) count++;
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            map.merge(sum, 1, Integer::sum);
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySumK ob = new SubArraySumK();
        int[] a = {1, 1, 1};
        System.out.println(ob.subarraySum(a, 2));
    }
}
