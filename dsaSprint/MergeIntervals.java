package dsaSprint;

import dsaSprint.MergeIntervals.CustomComparator;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    static class CustomComparator implements Comparator<Integer[]> {
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return o1[0].compareTo(o2[0]);
        }
    }


}
