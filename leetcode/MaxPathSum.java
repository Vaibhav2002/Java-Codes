package leetcode;

public class MaxPathSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int max;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        max = Integer.MIN_VALUE;
        count(root);
        return max;
    }

    private int count(TreeNode root) {
        if (root == null) return 0;
        int left = count(root.left);
        int right = count(root.right);
        int maxVal = root.val;
        maxVal = Math.max(maxVal, left + root.val);
        maxVal = Math.max(maxVal, right + root.val);
        max = Math.max(max, root.val + left + right);
        max = Math.max(max, maxVal);
        return maxVal;
    }
}
