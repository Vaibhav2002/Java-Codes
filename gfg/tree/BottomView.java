package gfg.tree;

import java.util.ArrayList;
import java.util.TreeMap;

public class BottomView {
    private static class NodeWithHD {
        int data, level;

        public NodeWithHD(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    static ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer, NodeWithHD> bottomView = new TreeMap<>();
        fillUsingDFS(root, 0, 0, bottomView);
        var ans = new ArrayList<Integer>();
        for(NodeWithHD node:bottomView.values()) ans.add(node.data);
        return ans;
    }

    private static void fillUsingDFS(Node root, int hd, int level, TreeMap<Integer, NodeWithHD> topView) {
        if (root == null) return;
        var prev = topView.get(hd);
        if (prev == null || level > prev.level) topView.put(hd, new NodeWithHD(root.data, level));
        fillUsingDFS(root.left, hd - 1, level + 1, topView);
        fillUsingDFS(root.right, hd + 1, level + 1, topView);
    }
}
