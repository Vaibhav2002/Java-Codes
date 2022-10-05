package gfg.heap;

import java.util.ArrayList;
import java.util.Comparator;

public class MaximumNumberOfEvents {

    private static class Event {
        int start, end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int maxEvents(int[] start, int[] end, int n) {
        var events = new ArrayList<Event>();
        for (int i = 0; i < n; i++) events.add(new Event(start[i], end[i]));
        events.sort(Comparator.comparingInt((Event e) -> e.end));
        int count = 0;
        int maxTime = events.get(0).end;
        for (int i = 1; i < n; i++) {
            if (events.get(i).start > maxTime) {
                maxTime = events.get(i).end;
                count++;
            }
        }
        return count;
    }
}
