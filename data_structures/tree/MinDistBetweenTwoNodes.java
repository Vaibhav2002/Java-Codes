package data_structures.tree;

import java.util.HashMap;
import java.util.HashSet;

public class MinDistBetweenTwoNodes {

    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    private static void computeParentMap(Node root, HashMap<Node, Node> hash) {
        if (root == null || (root.left == null && root.right == null))
            return;
        if (root.left != null)
            hash.put(root.left, root);
        if (root.right != null)
            hash.put(root.right, root);
        computeParentMap(root.left, hash);
        computeParentMap(root.right, hash);
    }

    private static void computeDistance(Node root, int dist, HashMap<Node, Integer> hash) {
        if (root == null)
            return;
        hash.put(root, dist);
        computeDistance(root.left, dist + 1, hash);
        computeDistance(root.right, dist + 1, hash);
    }


    private static Node findLca(Node x, Node y, HashMap<Node, Node> hash) {
        HashSet<Node> xRoute = new HashSet<>();
        Node tmpx = x;
        Node tmpy = y;
        xRoute.add(tmpx);
        while (hash.get(tmpx) != tmpx) {
            xRoute.add(hash.get(tmpx));
            tmpx = hash.get(tmpx);
        }
        while (hash.get(tmpy) != tmpy) {
            Node paremt = hash.get(tmpy);
            if (xRoute.contains(paremt))
                return paremt;
            tmpy = paremt;
        }
        return null;
    }

    private static int findDistFromLca(Node x, Node lca, HashMap<Node, Node> hash) {
        int count = 0;
        Node tmpx = x;
        while (hash.get(tmpx) != tmpx) {
            Node parent = hash.get(tmpx);
            count++;
            if (parent == lca)
                break;
            tmpx = parent;
        }
        return count;
    }

    private static int findMinDist(Node x, Node y, Node root) {
        HashMap<Node, Node> parentMap = new HashMap<>();
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        parentMap.put(root, root);
        computeParentMap(root, parentMap);
        computeDistance(root, 0, distanceMap);
        Node lca = findLca(x, y, parentMap);
        int distLca = distanceMap.get(lca);
        int distX = distanceMap.get(x);
        int distY = distanceMap.get(y);
        return distX + distY - 2 * distLca;
    }

    private static int findDist(Node x, Node y, Node root) {
        HashMap<Node, Node> parentMap = new HashMap<>();
        parentMap.put(root, root);
        computeParentMap(root, parentMap);
        Node lca = findLca(x, y, parentMap);
        int dist1 = findDistFromLca(x, lca, parentMap);
        int dist2 = findDistFromLca(y, lca, parentMap);
        return dist1 + dist2;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(10);
        root.left.left = new Node(18);
        root.left.right = new Node(15);
        root.right.left = new Node(20);
        root.right.right = new Node(0);
        System.out.println(findMinDist(root.left.left, root.right.right, root));
    }
}
