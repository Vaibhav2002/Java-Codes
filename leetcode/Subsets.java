package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        form(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void form(int index, int[] nums, List<Integer> formed, List<List<Integer>> ans) {
        if (index >= nums.length) return;
        if (index == nums.length - 1) {
            ans.add(formed);
            formed.add(nums[index]);
            ans.add(formed);
            return;
        }
        form(index + 1, nums, new ArrayList<>(List.copyOf(formed)), ans);
        var copy = new ArrayList<>(List.copyOf(formed));
        copy.add(nums[index]);
        form(index + 1, nums, copy, ans);
    }
}