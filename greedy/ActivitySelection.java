package greedy;

import java.util.PriorityQueue;

public class ActivitySelection {
    static class Activity implements Comparable<Activity> {
        int start, end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return end - o.end;
        }
    }

    public static int activitySelection(int start[], int end[], int n) {
        var pq = getActivityList(start, end, n);
        int count = 0;
        var currActivity = pq.poll();
        count++;
        while (!pq.isEmpty()) {
            var activity = pq.poll();
            if (activity.start >= currActivity.end) {
                count++;
                currActivity = activity;
            }
        }
        return count;
    }

    private static PriorityQueue<Activity> getActivityList(int[] start, int[] end, int n) {
        var ans = new PriorityQueue<Activity>();
        for (int i = 0; i < n; i++) ans.add(new Activity(start[i], end[i]));
        return ans;
    }
}
