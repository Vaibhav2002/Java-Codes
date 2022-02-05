package leetcode;

public class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) return new int[]{0, 0};
            else return new int[]{-1, -1};
        }
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    public int findFirst(int[] a, int target) {
        int l = 0, u = a.length - 1;
        while (l < u) {
            int mid = l + (u - l) / 2;
            if (a[mid] == target) {
                if (mid == 0 || a[mid - 1] != target) return mid;
                else u = mid;
            } else if (a[mid] < target) l = mid + 1;
            else u = mid;
        }
        return (l == u && a[l] == target) ? l : -1;
    }

    public int findLast(int[] a, int target) {
        int l = 0, u = a.length - 1;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (a[mid] == target && mid == a.length - 1 && a[mid + 1] != target) return mid;
            else if (a[mid] > target) u = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

}
