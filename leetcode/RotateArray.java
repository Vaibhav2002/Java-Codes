package leetcode;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] a, int start, int end) {
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            int temp = a[start + i];
            a[start + i] = a[end - i];
            a[end - i] = temp;
        }
    }
}
