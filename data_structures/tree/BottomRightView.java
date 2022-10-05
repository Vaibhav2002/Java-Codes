package data_structures.tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/bottom-right-view-of-binary-tree_1081489">Problem</a>
 **/
public class BottomRightView {
    private static class BinaryTreeNode<T> {

        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = right = null;
        }

    }

    private static class Node {
        int data, level;

        public Node(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    public static ArrayList<Integer> bottomRightView(BinaryTreeNode<Integer> root) {
        var map = new HashMap<Integer, Node>();
        fill(root, 0, map);
        return new ArrayList<>(map.keySet().stream().map((key) -> map.get(key).data).sorted().toList());
    }

    private static void fill(BinaryTreeNode<Integer> root, int level, HashMap<Integer, Node> map) {
        if (root == null) return;
        fill(root.right, level, map);
        var prev = map.get(level);
        if (prev == null || prev.level < level) map.put(level, new Node(root.data, level));
        fill(root.left, level + 1, map);
    }
}
