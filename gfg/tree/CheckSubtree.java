package gfg.tree;

import java.util.ArrayList;
import java.util.Objects;

public class CheckSubtree {
    public static boolean isSubtree(Node T, Node S) {
        ArrayList<Integer> inOrder1 = new ArrayList<>(), inOrder2 = new ArrayList<>();
        getInorder(T, inOrder1);
        getInorder(S, inOrder2);
        return doesExist(inOrder1, inOrder2);
    }

    private static boolean doesExist(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0, j = 0, count = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i).equals(b.get(j))) {
                i++;
                j++;
                if (j == b.size()) return true;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return false;
    }

    private static void getInorder(Node root, ArrayList<Integer> inOrder) {
        if (root == null) return;
        getInorder(root.left, inOrder);
        inOrder.add(root.data);
        getInorder(root.right, inOrder);
    }

    private static boolean checkUsingDFS(Node root1, Node root2){
        if(root1 == null) return false;
        if(areTreesSame(root1, root2)) return true;
        return areTreesSame(root1.left, root2) || areTreesSame(root1.right, root2);
    }

    private static boolean areTreesSame(Node root1, Node root2) {
        if (root1.data != root2.data) return false;
        return areTreesSame(root1.left, root2.left) && areTreesSame(root1.right, root2.right)
    }
}
