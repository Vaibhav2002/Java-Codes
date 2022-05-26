package leetcode.graph;

/**
 * <a href="https://leetcode.com/problems/number-of-operations-to-make-network-connected/">Problem</a>
 */
public class OperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        int disConnectedCount = countDisconnectedComputers(connections, n);
        int edges = connections.length;
        int connectCount = n - disConnectedCount;
        int extraEdges = edges - connectCount-1;
        if(extraEdges < disConnectedCount) return -1;
        else return disConnectedCount;
    }

    private int countDisconnectedComputers(int[][] connections, int n){
        int[] order = new int[n];
        for(int[] i:connections){
            order[i[0]]++;
            order[i[1]]++;
        }
        int disConnectedCount = 0;
        for(int i=0;i<n;i++) if(order[i] == 0) disConnectedCount++;
        return disConnectedCount;
    }
}
