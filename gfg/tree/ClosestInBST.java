package gfg.tree;

public class ClosestInBST {
    static int ans;
    static int minDiff(Node  root, int K)
    {
        ans = Integer.MAX_VALUE;
        findUsingDFS(root, K);
        return ans;
    }

    private static void findUsingDFS(Node root, int k){
        if(root == null) return;
        if(root.data > k)
            findUsingDFS(root.left, k);
        else{
            ans = Math.min(ans, Math.abs(k - root.data));
            findUsingDFS(root.right, k);
        }
    }

    private static int getRightMax(Node root, int k){
        if(root == null) return Integer.MAX_VALUE;
        if(root.data == k) return k;
        if(root.data < k) return getRightMax(root.right, k);
        else return Math.min(root.data, getRightMax(root.right, k));
    }
}
