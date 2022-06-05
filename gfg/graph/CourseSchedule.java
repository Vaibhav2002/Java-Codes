package gfg.graph;

import java.util.*;

public class CourseSchedule {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites)
    {
        var topo = findTopoSort(n, getAdj(n, prerequisites));
         System.out.println(topo.toString());
        if(topo.size() !=n) return new int[n];
        int[] tp = new int[n];
        for(int i=0;i<n;i++) tp[i] = topo.get(i);
        return tp;
    }

    private static ArrayList<Integer> findTopoSort(int n, ArrayList<ArrayList<Integer>> adj){
        var topo = new ArrayList<Integer>();
        Queue<Integer> que = new LinkedList<>();
        var inDegree = findInDegree(n, adj);
        for(int i=0;i<n;i++) if(inDegree[i] == 0) que.add(i);
        while(!que.isEmpty()){
            var node = que.poll();
            topo.add(node);
            for(Integer edge:adj.get(node)){
                inDegree[edge]--;
                if(inDegree[edge] == 0) que.add(edge);
            }
        }
        return topo;
    }

    private static int[] findInDegree(int n, ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[n];
        for(int i=0;i<n;i++){
            for(Integer j:adj.get(i)) inDegree[j]++;
        }
        return inDegree;
    }

    private static ArrayList<ArrayList<Integer>> getAdj(int n, ArrayList<ArrayList<Integer>> pr){
        var adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer> i: pr){
            adj.get(i.get(1)).add(i.get(0));
        }
        return adj;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        var pre = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<m;i++){
            var edge = new ArrayList<Integer>();
            edge.add(sc.nextInt());
            edge.add(sc.nextInt());
            pre.add(edge);
        }
        System.out.println(Arrays.toString(findOrder(n, m, pre)));
    }
}
