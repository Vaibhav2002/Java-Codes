package data_structures.tree;

public class creation {

    static class Node {
        Node left, right;
        int data;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        //creating tree
        creation.Node head = new creation.Node(5);
        head.left = new creation.Node(7);
        head.right = new creation.Node(10);
        head.left.left = new creation.Node(18);
        head.left.right = new creation.Node(15);
        head.right.left = new creation.Node(20);
        head.right.right = new creation.Node(0);
        //creating tree
        DFS.preorderIter(head);
        System.out.println();
        DFS.preorderRecur(head);
        System.out.println();
        DFS.MorrisPreorder(head);
    }
}
