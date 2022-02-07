package leetcode;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = prod;
            prod *= nums[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) ans[i] = prefix[i] * suffix[i];
        return ans;
    }
}
