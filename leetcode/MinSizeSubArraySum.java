package leetcode;

/**
* <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">Problem</a>
**/
public class MinSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>target) sum-=nums[start++];
            if(sum>=target) ans = Math.min(ans, i - start+1);
        }
        return ans;
    }
}
