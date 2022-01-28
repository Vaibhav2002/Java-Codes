package data_structures.tree;

import java.util.Arrays;

public class postfrom_In_Pre {
    //utility function to find index of root
    static int find(int[] a, int x, int n) {
        for (int i = 0; i < n; i++)
            if (a[i] == x)
                return i;
        return -1;
    }

    //printing post order from given preorder and inorder traversal
    static void printPost(int[] in, int[] pre, int n) {
        //searching for root
        int root = find(in, pre[0], n);
        if (root != 0)//checking if left sutree exists
            printPost(in, Arrays.copyOfRange(pre, 1, n), root);// for left subtree
        if (root != n - 1)//checking if right subtree exists
            //for right subtree
            printPost(Arrays.copyOfRange(in, root + 1, n), Arrays.copyOfRange(pre, root + 1, n), n - root - 1);
        System.out.print(pre[0] + " ");
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
        int[] in = {18, 7, 15, 5, 20, 10, 0}; //inorder traversal
        int[] pre = {5, 7, 18, 15, 10, 20, 0};//preorder traversal
        printPost(in, pre, in.length);
    }
}
