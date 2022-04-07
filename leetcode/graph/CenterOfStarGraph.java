package leetcode.graph;

public class CenterOfStarGraph {
    public int findCenter(int[][] edges) {
        int n = 0;
        for (int[] i : edges) {
            n = Math.max(n, Math.max(i[0], i[1]));
        }
        int[] from = new int[n], to = new int[n];
        for (int[] i : edges) {
            from[i[0]]++;
            to[i[1]]++;
            from[i[1]]++;
            to[i[0]]++;
        }
        int ans = -1;
        for (int i = 0; i < to.length; i++) {
            if (to[i] == n - 1) return i;
        }
        return -1;
    }
}
