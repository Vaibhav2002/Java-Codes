package arraycodes;

import java.util.Arrays;
import java.util.Comparator;

public class SortByHamming {
    public static class HammingComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (countOneInBinary(o1) > countOneInBinary(o2))
                return 1;
            else if (countOneInBinary(o1) < countOneInBinary(o2))
                return -1;
            else
                return Integer.compare(o1, o2);
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }

        public int countOneInBinary(Integer n) {
            int count = 0;
            while (n > 0) {
                n &= (n - 1);
                count++;
            }
            return count;
        }
    }

    public int[] solve(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        int index = 0;
        for (int i : nums) {
            ans[index++] = i;
        }
        Arrays.sort(ans, new HammingComparator());
        int[] sorted = new int[ans.length];
        index = 0;
        for (Integer i : ans) {
            sorted[index++] = i;
        }
        return sorted;
    }

    public static void main(String[] args) {
        SortByHamming ob = new SortByHamming();
        System.out.println(Arrays.toString(ob.solve(new int[]{3, 1, 4, 7})));
    }
}
