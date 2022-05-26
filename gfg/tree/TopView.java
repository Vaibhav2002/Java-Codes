package gfg.tree;

import java.util.*;


public class TopView {

    private static class NodeWithHD {
        int data, level;

        public NodeWithHD(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer, NodeWithHD> topView = new TreeMap<>();
        fillUsingDFS(root, 0, 0,topView);
        var ans = new ArrayList<Integer>();
        for(NodeWithHD node:topView.values()) ans.add(node.data);
        return ans;
    }

    private static void fillUsingDFS(Node root, int hd, int level, TreeMap<Integer, NodeWithHD> topView) {
        if (root == null) return;
        var prev = topView.get(hd);
        if (prev == null || level < prev.level) topView.put(hd, new NodeWithHD(root.data, level));
        fillUsingDFS(root.left, hd - 1, level + 1, topView);
        fillUsingDFS(root.right, hd + 1, level + 1, topView);
    }
}
