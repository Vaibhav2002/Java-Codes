package leetcode;

public class JumpGame2 {

    public int jump(int[] nums) {
        return find(0, nums) - 1;
    }

    private int find(int index, int nums[]) {
        if (index == nums.length - 1) return 1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            if (index + i < nums.length && nums[index + 1] != 0)
                min = Math.min(min, find(index + i, nums));
        }
        return min;
    }
}
