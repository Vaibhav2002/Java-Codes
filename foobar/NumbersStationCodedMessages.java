package foobar;

import java.util.Arrays;

public class NumbersStationCodedMessages {
    public static int[] solution(int[] l, int t) {
        int sum = 0;
        int startIndex = 0, endIndex = Integer.MIN_VALUE;
        for (int i = 0; i < l.length; i++) {
            if (sum < t) sum += l[i];
            if (sum == t) {
                endIndex = i;
                break;
            } else {
                while (sum > t) {
                    sum -= l[startIndex];
                    startIndex++;
                }
                if (sum == t) {
                    endIndex = i;
                    break;
                }
            }
        }
        boolean hasFound = endIndex != Integer.MIN_VALUE;
        return new int[]{hasFound ? startIndex : -1, hasFound ? endIndex : -1};

    }

    public static void main(String[] args) {
        int[] ar = {20, 30, 40, 50};
        int target = 15;
        System.out.println(Arrays.toString(solution(ar, target)));
    }
}
