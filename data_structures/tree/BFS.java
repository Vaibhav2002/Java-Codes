package data_structures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    //this function prints level order traversal
    static void levelOrder(creation.Node root) {
        if (root == null) //if there is no tree
            return;
        Queue<creation.Node> ob = new LinkedList<>();
        ob.add(root);
        while (!ob.isEmpty()) {
            creation.Node temp = ob.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                ob.add(temp.left);
            if (temp.right != null)
                ob.add(temp.right);
        }
    }

    //this function prints level order traversal line by line
    static void levelOrder_line(creation.Node root) {
        if (root == null) //if there is no tree
            return;
        Queue<creation.Node> ob = new LinkedList<>();
        ob.add(root);
        while (true) {
            int count = ob.size();
            if (count == 0)
                break;

            while (count > 0) {
                creation.Node temp = ob.poll();
                assert temp != null;
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    ob.add(temp.left);
                if (temp.right != null)
                    ob.add(temp.right);
                count--;
            }
            System.out.println();
        }
    }
    //this function prints level order in reverse order
    static void reverseLevelOrder(creation.Node root) {
        if (root == null) //if there is no tree
            return;
        Queue<creation.Node> ob = new LinkedList<>();
        Stack<creation.Node> st = new Stack<>();
        ob.add(root);
        while (!ob.isEmpty()) {
            creation.Node temp = ob.poll(); //pushing to stack rather than printing like normal level order
            st.push(temp);
            if (temp.right != null) //first right node is pushed to maintain left to right printing order
                ob.add(temp.right);
            if (temp.left != null)
                ob.add(temp.left);
        }
        while (!st.isEmpty())
            System.out.print(st.pop().data + " ");
    }
}
