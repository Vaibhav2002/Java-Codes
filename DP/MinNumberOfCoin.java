package DP;

import java.util.ArrayList;
import java.util.List;

public class MinNumberOfCoin {
    static int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

    static List<Integer> minPartition(int N) {
        var ans = new ArrayList<Integer>();
        int index = coins.length - 1;
        while (N > 0 && index >= 0) {
            int count = N / coins[index];
            N = N % coins[index];
            for(int i=0;i<count;i++) ans.add(coins[index]);
        }
        return ans;
    }
}
