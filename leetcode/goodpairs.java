package leetcode;

import java.util.HashMap;

public class goodpairs {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> ob = new HashMap<>();
        int val = 0;
        for (int i : nums)
            if (ob.containsKey(i))
                ob.replace(i, ob.get(i) + 1);
            else
                ob.put(i, 1);
        for (int i : ob.keySet())
            val += ob.get(i) * (ob.get(i) - 1) / 2;
        return val;


    }

    public static void main(String[] args) {
        goodpairs ob = new goodpairs();
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(ob.numIdenticalPairs(nums));
    }
}
