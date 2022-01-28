package DP.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>Leetcode Question No. 605</h1>
 * You have a long flowerbed in which some plots are planted,
 * and some are not. However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's,
 * where 0 means empty and 1 means not empty, and an integer n,
 * return if n new flowers can be planted in the flowerbed without
 * violating the no-adjacent-flowers rule.
 *
 * <h3>Example 1</h3>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 *
 * <h3>Example </h3>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 */

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int dp[][] = new int[flowerbed.length + 1][n + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return isPossible(flowerbed, 0, n, dp);
    }

    public boolean isPossible(int[] flowerBed, int i, int n, int[][] dp) {
        if (n == 0) return true;
        if (i >= flowerBed.length) return false;
        if (dp[i][n] != -1) return dp[i][n] == 1;
        boolean isCurrentIndexPlanted = flowerBed[i] == 1;
        boolean fromCurrent;
        if (isCurrentIndexPlanted) fromCurrent = isPossible(flowerBed, i + 2, n, dp);
        else {
            boolean withPlanting = isPossible(flowerBed, i + 2, n - 1, dp);
            boolean withoutPlanting = isPossible(flowerBed, i + 1, n, dp);
            fromCurrent = withPlanting || withoutPlanting;
        }
        dp[i][n] = fromCurrent?1:0;
        return fromCurrent;
    }

    public static void main(String[] args) {
        int[] flowerBed = {1, 0, 0, 0, 1};
        int n = 2;
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerBed, n));

    }
}
