package leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/maximum-total-importance-of-roads/">Problem</a>
 **/
public class MaximumTotalImportanceOfRoads {

//    private static class City implements Comparable<City> {
//        int data, degree;
//
//        public City(int data, int degree) {
//            this.data = data;
//            this.degree = degree;
//        }
//
//        @Override
//        public int compareTo(City o) {
//            return Integer.compare(o.degree, degree);
//        }
//    }
//
//    private int num;
//
//    public long maximumImportance(int n, int[][] roads) {
//        boolean[] visited = new boolean[n];
//        var degree = degree(roads, n);
//        var pq = new PriorityQueue<City>();
//        for (int i = 0; i < n; i++) pq.add(new City(i, degree[i]));
//        var adj = getAdjList(roads, degree, n);
//        long sum = 0;
//        int number[] = new int[n];
//        num = n;
//        for(City city:pq){
//            if(!visited[city.data]) sum+=dfs(city.data, adj, visited);
//        }
//        return sum;
//    }
//
//    private long dfs(int start, ArrayList<PriorityQueue<City>> adj, boolean[] visited, int[] number) {
//        visited[start] = true;
//        number[start] = num;
//        long sum = num;
//        num--;
//        for (City city : adj.get(start)) {
//            if (!visited[city.data])
//                sum += dfs(city.data, adj, visited, number);
//            else sum+=number[city.data];
//        }
//        return sum;
//    }
//
//    private int[] degree(int[][] graph, int n) {
//        int[] degree = new int[n];
//        for (int[] i : graph) {
//            degree[i[0]]++;
//            degree[i[1]]++;
//        }
//        return degree;
//    }
//
//    private ArrayList<PriorityQueue<City>> getAdjList(int[][] graph, int[] degree, int n) {
//        var ans = new ArrayList<PriorityQueue<City>>();
//        for (int i = 0; i < n; i++) ans.add(new PriorityQueue<>());
//        for (int[] i : graph) {
//            ans.get(i[0]).add(new City(i[1], degree[i[1]]));
//            ans.get(i[1]).add(new City(i[0], degree[i[0]]));
//        }
//        return ans;
//    }
}
