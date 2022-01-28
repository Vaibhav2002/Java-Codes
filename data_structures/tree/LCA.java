package data_structures.tree;

public class LCA {
    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    private static boolean found1;
    private static boolean found2;


    //this function finds LCA of two nodes using recursion given that both nodes will be present
    private static Node findLcaStatedNodesExist(Node root, Node x, Node y) {
        if (root == null)
            return null;
        if (root == x || root == y) //if root equals any node then its the LCA
            return root;
        Node left = findLcaStatedNodesExist(root.left, x, y); //check for left subtree
        Node right = findLcaStatedNodesExist(root.right, x, y);//check for right subtree
        if (left == null && right == null) //if the nodes are not found in both subtree , means no lca
            return null;
        if (left != null && right != null) // if nodes found then current node is lca
            return root;
        if (left != null) //if node found on left recur for right
            findLcaStatedNodesExist(root.right, x, y);
        else
            findLcaStatedNodesExist(root.left, x, y); //else if node found for right recur left
        return root;
    }

    //this function finds LCA of nodes irrespective of the existence
    //we need a wrapper function for it and two global boolean variables
    private static Node findLcaEvenIfNotExists(Node root, Node x, Node y) {
        if (root == null)
            return null;
        if (root == x || root == y) {
            if (root == x)
                found1 = true; //if one node found set value to true
            else
                found2 = true; //if second node found set value to true
            return root;
        }
        Node left = findLcaEvenIfNotExists(root.left, x, y); //check for left subtree
        Node right = findLcaEvenIfNotExists(root.right, x, y);//check for right subtree
        if (left == null && right == null) //if the nodes are not found in both subtree , means no lca
            return null;
        if (left != null && right != null) // if nodes found then current node is lca
            return root;
        if (left != null) //if node found on left recur for right
            findLcaEvenIfNotExists(root.right, x, y);
        else
            findLcaEvenIfNotExists(root.left, x, y); //else if node found for right recur left
        return root;
    }


    private static Node findLca(Node root, Node x, Node y) {
        Node lca = findLcaEvenIfNotExists(root, x, y);
        return (found2 && found1) ? lca : null; //if both nodes are found return true else false
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(10);
        root.left.left = new Node(18);
        root.left.right = new Node(15);
        root.right.left = new Node(20);
        root.right.right = new Node(0);
        Node x = root.right.left = new Node(20), y = root.left.left = new Node(18);
        System.out.println(findLcaStatedNodesExist(root, x, y));
        System.out.println(findLca(root, x, y));
    }

}
