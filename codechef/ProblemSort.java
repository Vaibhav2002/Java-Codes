package codechef;

import java.util.*;

/**
 * <a href="https://www.codechef.com/problems/PROBLEMS">CodeChef Url</a>
 */
public class ProblemSort {

    static class Difficulty implements Comparable<Difficulty> {
        int n, index;

        Difficulty(int n, int index) {
            this.n = n;
            this.index = index;
        }

        @Override
        public int compareTo(Difficulty o) {
            if (n != o.n) return n - o.n;
            else return index - o.index;
        }
    }

    static class SubTask implements Comparable<SubTask> {
        int score, participants;

        SubTask(int score, int participants) {
            this.score = score;
            this.participants = participants;
        }

        @Override
        public int compareTo(SubTask o) {
            return score - o.score;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int p = sc.nextInt(), s = sc.nextInt();
        PriorityQueue<Difficulty> pq = new PriorityQueue<>();
        for (int i = 0; i < p; i++) {
            int[] score = new int[s];
            int[] participants = new int[s];
            List<SubTask> subtasks = new ArrayList<>();
            Collections.sort(subtasks);
            for (int j = 0; j < s; j++) score[j] = sc.nextInt();
            for (int j = 0; j < s; j++) participants[j] = sc.nextInt();
            for (int j = 0; j < s; j++) subtasks.add(new SubTask(score[i], participants[i]));
            int n = countN(subtasks);
            pq.add(new Difficulty(n, i));
        }
        while (!pq.isEmpty()) System.out.println(pq.poll().index + 1);
    }

    private static int countN(List<SubTask> subtasks) {
        int n = 0;
        for (int i = 0; i < subtasks.size() - 1; i++)
            if (subtasks.get(i).participants > subtasks.get(i + 1).participants) n++;
        return n;
    }
}
