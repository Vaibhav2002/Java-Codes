package data_structures.tree;

public class tree2doublylinkedlist {
    creation.Node head;
    creation.Node prev; //static so that value remains same in all recursion
    creation.Node root;

    void convert(creation.Node root) {
        if (root == null)
            return;
        convert(root.left); //recur for left subtree
        if (prev == null) //if it is the first node
            head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convert(root.right); //recur for right subtree
    }

    void displayList(creation.Node head) { //utility function to display list
        creation.Node temp = head; //temporary variable to store head node
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    public static void main(String[] args) {
        tree2doublylinkedlist ob = new tree2doublylinkedlist();
        //creating tree
        ob.root = new creation.Node(5);
        ob.root.left = new creation.Node(7);
        ob.root.right = new creation.Node(10);
        ob.root.left.left = new creation.Node(18);
        ob.root.left.right = new creation.Node(15);
        ob.root.right.left = new creation.Node(20);
        ob.root.right.right = new creation.Node(0);
        //creating tree
        DFS.inorderRecur(ob.root); //inorder of tree
        ob.convert(ob.root); //creating doubly linked list
        System.out.println();
        ob.displayList(ob.head); //traversing Doubly Linked lIst

    }
}
