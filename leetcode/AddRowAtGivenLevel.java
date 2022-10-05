package leetcode;

import com.sun.source.tree.Tree;
import data_structures.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
* <a href="https://leetcode.com/problems/add-one-row-to-tree/">Problem</a>
**/
public class AddRowAtGivenLevel {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            var newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        //going to the depth just before the required
        while(!que.isEmpty() && --depth>1){
            int len = que.size();
            for(int i = 0;i<len;i++){
                var node = que.poll();
                if(node.left != null) que.add(node.left);
                if(node.right !=null) que.add(node.right);
            }
        }
        //adding row of nodes at given depth
        while(!que.isEmpty()){
            var node = que.poll();
            TreeNode leftNode = new TreeNode(val), rightNode = new TreeNode(val);
            leftNode.left = node.left;
            rightNode.right = node.right;
            node.left = leftNode;
            node.right = rightNode;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        int depth = 4;
        root = new AddRowAtGivenLevel().addOneRow(root, 5, depth);
    }
}
