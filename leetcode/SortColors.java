package leetcode;

public class SortColors {
    public void sortColors(int[] nums) {
        int l = 0, mid = 0, u = nums.length - 1;
        while (mid <= u) {
            if (nums[mid] == 0) {
                swap(l, mid, nums);
                l++;
                mid++;
            } else if (nums[mid] == 1) mid++;
            else {
                swap(mid, u, nums);
                u--;
            }
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
