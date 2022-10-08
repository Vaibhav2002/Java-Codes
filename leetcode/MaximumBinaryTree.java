package leetcode;

import data_structures.tree.TreeNode;

/**
* <a href="https://leetcode.com/problems/maximum-binary-tree/description/">Problem</a>
**/
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return fill(nums, 0, nums.length - 1);
    }

    private TreeNode fill(int[] a, int start, int end){
        if(start>end) return null;
        int max = findMax(a, start, end);
        TreeNode node = new TreeNode(a[max]);
        node.left = fill(a, start, max - 1);
        node.right = fill(a, max+1, end);
        return node;
    }

    private int findMax(int[] a, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++)
            if (a[i] > a[maxIndex]) maxIndex = i;
        return maxIndex;
    }

}
