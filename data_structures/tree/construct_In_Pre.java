package data_structures.tree;

public class construct_In_Pre {
    creation.Node root;
    int preindex = 0;

    int find(int[] in, int start, int end, int x) { // utility function to find index of root assuming root is present
        for (int i = start; i <= end; i++)
            if (in[i] == x)
                return i;
        return end;
    }

    creation.Node constructTree(int[] in, int[] pre, int inStart, int inEnd) {
        if (inStart > inEnd) //if start exceeds end return null as tree cannot exist
            return null;
        creation.Node tnode = new creation.Node(pre[preindex++]); //taking first node from pre as the root of the tree
        if (inStart == inEnd) // checking if it is a leaf then return node
            return tnode;
        int index = find(in, inStart, inEnd, tnode.data);//findin the index of root in in to find left and right subtree
        tnode.left = constructTree(in, pre, inStart, index - 1);//construction from left subtree
        tnode.right = constructTree(in, pre, index + 1, inEnd);//construction from right subtree
        return tnode;
    }

    public static void main(String[] args) {
        int[] in = {1, 2, 3, 4, 5, 6}; //inorder
        int[] pre = {4, 2, 1, 3, 6, 5}; //preorder
        construct_In_Pre ob = new construct_In_Pre();
        ob.root = ob.constructTree(in, pre, 0, in.length - 1);
        DFS.inorderIter(ob.root); //printing inorder of tree constructed to check if tree is correct or not
    }
}