package data_structures.tree;

import java.util.Stack;

public class DFS {
    //this function prints inorder traversal using recursion
    static void inorderRecur(creation.Node root) {
        if (root == null) //if there is no tree
            return;
        inorderRecur(root.left);
        System.out.print(root.data + " ");
        inorderRecur(root.right);
    }

    //this function prints preorder traversal using recursion
    static void preorderRecur(creation.Node root) {
        if (root == null) //if there is no tree
            return;
        System.out.print(root.data + " ");
        preorderRecur(root.left);
        preorderRecur(root.right);
    }

    //this function prints postorder traversal using recursion
    static void postorderRecur(creation.Node root) {
        if (root == null) //if there is no tree
            return;
        postorderRecur(root.left);
        postorderRecur(root.right);
        System.out.print(root.data + " ");
    }

    //THis function prints inorder traversal using interation
    static void inorderIter(creation.Node root) {
        if (root == null) //if there is no tree
            return;
        Stack<creation.Node> ob = new Stack<>();
        creation.Node current = root;
        while (current != null || ob.size() > 0) {
            while (current != null) {
                ob.push(current);
                current = current.left;
            }
            current = ob.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    //this function prints preorder traversal using iteration
    static void preorderIter(creation.Node root) {
        if (root == null) //if there is no tree
            return;
        Stack<creation.Node> ob = new Stack<>();
        ob.push(root);
        while (!ob.isEmpty()) {
            creation.Node temp = ob.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) // right child is pushed first as stack is used and it follow LIFO
                ob.push(temp.right);
            if (temp.left != null)
                ob.push(temp.left);
        }
    }

    // this function prints postordeer traversal by iteration using 2 stacks
    static void postorderIter2stack(creation.Node root) {
        if (root == null)
            return;
        Stack<creation.Node> ob1 = new Stack<>();
        Stack<creation.Node> ob2 = new Stack<>();
        ob1.push(root);
        while (!ob1.isEmpty()) {
            creation.Node temp = ob1.pop();
            ob2.push(temp);
            if (temp.left != null)
                ob1.push(temp.left);
            if (temp.right != null)
                ob1.push(temp.right);
        }
        while (!ob2.isEmpty())
            System.out.print(ob2.pop().data + " ");
    }

    static void MorrisInorder(creation.Node root) {
        creation.Node current = root;
        if(root==null) //if tree does not exist
            return;
        while (current != null) {
            if (current.left == null) { //if left subtree does not exist print data and move to right child
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                creation.Node predecessor = current.left; // find predecessor node if subtree exists
                while (predecessor.right != null && predecessor.right.data != current.data)
                    predecessor = predecessor.right;
                if (predecessor.right == null) { //if right is null, link to current node and move to left child
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null; //remove link and print data and move to right child
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }
    static void MorrisPreorder(creation.Node root) {
        creation.Node current = root;
        if(root==null) //if tree does not exist
            return;
        while (current != null) {
            if (current.left == null) { //if left subtree does not exist print data and move to right child
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                creation.Node predecessor = current.left; // find predecessor node if subtree exists
                while (predecessor.right != null && predecessor.right.data != current.data)
                    predecessor = predecessor.right;
                if (predecessor.right == null) { //if right is null, link to current node , print and move to left child
                    predecessor.right = current;
                    System.out.print(current.data + " ");
                    current = current.left;
                } else {
                    predecessor.right = null; //remove link and move to right child
                    current = current.right;
                }
            }
        }
    }
}
