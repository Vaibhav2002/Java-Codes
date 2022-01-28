package data_structures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class VerticalOrder {

    public void verticalTraversal(TreeNode root) {
        var verticalTraversal = new TreeMap<Integer, List<Integer>>();
        fillVerticalTraversal(root, 0, verticalTraversal);
        for (int hd : verticalTraversal.keySet()) {
            for (int value : verticalTraversal.get(hd))
                System.out.print(value + " ");
            System.out.println();
        }
    }

    public void fillVerticalTraversal(TreeNode root, int hd, TreeMap<Integer, List<Integer>> map) {
        if (root == null) return;
        map.computeIfAbsent(hd, integer -> new ArrayList<>());
        map.get(hd).add(root.data);
        fillVerticalTraversal(root.left, hd - 1, map);
        fillVerticalTraversal(root.right, hd + 1, map);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(19);
        VerticalOrder ob = new VerticalOrder();
        ob.verticalTraversal(root);
    }

}
