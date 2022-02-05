package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        find(nums, new ArrayList<>(), ans);
        return ans;
    }

    public void find(int[] nums, List<Integer> formed, List<List<Integer>> ans) {
        if (formed.size() == nums.length) {
            ans.add(formed);
            return;
        }
        for (int i : nums) {
            if (!formed.contains(i)) {
                var cloned = new ArrayList<>(List.copyOf(formed));
                cloned.add(i);
                find(nums, cloned, ans);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[] nums = {1,2,3};
        Permutations ob = new Permutations();
        System.out.println(ob.permute(nums));
    }
}
