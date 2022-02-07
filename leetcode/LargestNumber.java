package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        Arrays.sort(nums, (a, b) -> {
            String a1 = a.toString(), b1 = b.toString();
            int minLength = a1.length(), len2 = b1.length();

        });
        StringBuilder ans = new StringBuilder();
        for (Integer a : values) ans.append(a);
        return ans.toString();
    }
}
