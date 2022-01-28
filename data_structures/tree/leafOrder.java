package data_structures.tree;

import java.util.Stack;

public class leafOrder {
    static boolean isLeaf(creation.Node head) { //checking if node is a leaf node or not
        return head.left == null && head.right == null;
    }

    static boolean leafTraversalCheck(creation.Node root1, creation.Node root2) {
        if (root1 == null || root2 == null) // if either tree or both tree doesnt exist
            return false;
        Stack<creation.Node> s1 = new Stack<>();
        Stack<creation.Node> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while (!s1.empty() && !s2.empty()) {
            if (s1.empty() || s2.empty())
                return false;
            creation.Node temp1 = s1.pop();
            while (temp1 != null && !isLeaf(temp1)) {
                if (temp1.right != null)
                    s1.push(temp1.right);
                if (temp1.left != null) //left child is pushed after as it will be popped before as using stack
                    s1.push(temp1.left);
                temp1 = s1.pop();
            }
            creation.Node temp2 = s2.pop();
            while (temp2 != null && !isLeaf(temp2)) {
                if (temp2.right != null)
                    s1.push(temp2.right);
                if (temp2.left != null) //left child is pushed after as it will be popped before as using stack
                    s1.push(temp2.left);
                temp2 = s1.pop();
            }

            if ((temp1 == null && temp2 != null) || (temp2 == null && temp1 != null))
                return false;
            if (temp1 != null && temp1.data != temp2.data)
                return false;
        }
        return true; //will return true is leaves are same
    }

    public static void main(String[] args) {
        //creating 1st tree
        creation.Node head = new creation.Node(5);
        head.left = new creation.Node(7);
        head.right = new creation.Node(10);
        head.left.left = new creation.Node(18);
        head.right.right = new creation.Node(15);
        head.right.left = new creation.Node(20);
        //creating 1st tree

        //creating 2nd tree
        creation.Node head2 = new creation.Node(15);
        head2.left = new creation.Node(18);
        head2.right = new creation.Node(25);
        head2.right.left = new creation.Node(20);
        head2.right.right = new creation.Node(15);
        //creating2nd tree

        if (leafTraversalCheck(head, head2))
            System.out.println("Same leaves");
        else
            System.out.println("Not same leaves");
    }
}