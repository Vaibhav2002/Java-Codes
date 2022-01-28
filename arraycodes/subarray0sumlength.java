package arraycodes;

import java.util.HashMap;

class subarray0sumlength {
    int printsubArray(int[] a) {
        HashMap<Integer, Integer> ob = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (a[i] == 0 && maxLen == 0)
                maxLen = 1;
            if (sum == 0)
                maxLen = i + 1;
            if (ob.containsKey(sum)) {
                int j = ob.get(sum);
                maxLen = Math.max(maxLen, i - j);
            } else
                ob.put(sum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        subarray0sumlength ob = new subarray0sumlength();
        int[] a = {15,-2,2,-8,1,7,10,23};
        int val = ob.printsubArray(a);
        System.out.println("Max length with sum 0 :" + val);

    }
}