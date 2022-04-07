package DP.leetcode;

import com.sun.source.tree.Tree;
import data_structures.tree.TreeNode;

import java.util.HashMap;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        var dp = new HashMap<TreeNode, Integer>();
        return find(root, dp);
    }

    private int find(TreeNode root, HashMap<TreeNode, Integer> dp) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (dp.containsKey(root)) return dp.get(root);
        int without = find(root.left, dp) + find(root.right, dp);
        int taking = root.val;
        if (root.left != null) taking += find(root.left.left, dp) + find(root.left.right, dp);
        if (root.right != null) taking += find(root.right.left, dp) + find(root.right.right, dp);
        dp.put(root, Math.max(taking, without));
        return dp.get(root);
    }
}
