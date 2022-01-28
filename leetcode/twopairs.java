package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class twopairs {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> ob=new HashMap<>();
        for(int i=0;i<nums.length;i++)
            if(ob.containsKey(target-nums[i]))
                return new int[]{ob.get(target-nums[i]),i};
            else
                ob.put(nums[i],i);
        return null;
    }

    public static void main(String[] args) {
        twopairs ob=new twopairs();
        int[] b ={2, 7, 11, 15};
        int[] a =ob.twoSum(b,9);
        System.out.println(Arrays.toString(a));
    }
}
