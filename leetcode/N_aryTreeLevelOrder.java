package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_aryTreeLevelOrder {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root == null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<len;i++){
                var node = q.poll();
                if(node == null) continue;
                level.add(node.val);
                q.addAll(node.children);
            }
            ans.add(level);
        }
        return ans;
    }
}
