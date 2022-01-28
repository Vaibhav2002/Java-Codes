package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Sum3Closest {
    public int threeSumClosest(int[] nums, int target) {
        int min = nums[0] + nums[1] + nums[nums.length - 1];
        min = Math.abs(target - min);
        var ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return sum;
                else if (sum < target)
                    j++;
                else
                    k--;
                if (Math.abs(target - sum) < min) {
                    min = Math.abs(target - sum);
                    ans = sum;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new Sum3Closest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
