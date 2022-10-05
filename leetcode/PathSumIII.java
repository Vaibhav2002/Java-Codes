package leetcode;

import data_structures.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/path-sum-iii/">Problem</a>
 **/
public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        var paths = new ArrayList<ArrayList<Integer>>();
        paths(root, new ArrayList<>(), paths);
        System.out.println(paths.toString());
        int count = 0;
        for(ArrayList<Integer> path:paths) count+=countSubArrays(path, targetSum);
        return count;
    }

    private int countSubArrays(ArrayList<Integer> a, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum =0;
        int count =0;
        for(int i:a){
            sum+=i;
            if(map.containsKey(sum - target)) count+=map.get(sum - target);
            map.merge(sum, 1, Integer::sum);
        }
        return count;
    }

    private void paths(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths){
        if(root == null) return;
        path.add(root.val);
        if(root.left==null && root.right == null) paths.add(path);
        paths(root.left, new ArrayList<>(path), paths);
        paths(root.right, new ArrayList<>(path), paths);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        int sum = 8;
        PathSumIII ob = new PathSumIII();
        System.out.println(ob.pathSum(root, sum));
    }
}
