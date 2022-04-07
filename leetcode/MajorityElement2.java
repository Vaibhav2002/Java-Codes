package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        return getMajorityElement(nums);
    }

    private List<Integer> getMajorityElement(int[] nums) {
        int maj1 = 0, maj2 = 0;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maj1] == nums[i]) count1++;
            else if (nums[maj2] == nums[i]) count2++;
            else if (count1 == 0) {
                maj1 = i;
                count1 = 1;
            } else if (count2 == 0) {
                maj2 = i;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (isMajority(nums, maj1)) ans.add(maj1);
        if (isMajority(nums, maj2)) ans.add(maj2);
        return ans;
    }

    private boolean isMajority(int[] nums, int target) {
        int count = 0;
        for (int i : nums) if (i == target) count++;
        return count > nums.length / 3;
    }
}
