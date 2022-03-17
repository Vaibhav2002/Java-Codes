package leetcode;

public class TrappingRainWater {
    public int trap(int[] height) {
        int[] prefix = getPrefixArray(height), suffix = getSuffixArray(height);
        int water = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            int pre = prefix[i] - height[i];
            int suf = suffix[i] - height[i];
            water += Math.min(pre, suf);
        }
        return water;
    }

    private int[] getPrefixArray(int[] height) {
        int[] prefix = new int[height.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            prefix[i] = max;
        }
        return prefix;
    }

    private int[] getSuffixArray(int[] height) {
        int[] suffix = new int[height.length];
        int max = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            suffix[i] = max;
        }
        return suffix;
    }
}
