package algorithms.patternMatching;

import java.util.ArrayList;
import java.util.Scanner;

public class RabinKarp {

    private int hash(char c, int index) {
        return c * (int) Math.pow(10, index);
    }

    private ArrayList<Integer> getListFromIndexes(int i, int j) {
        var ans = new ArrayList<Integer>();
        if (i != -1 && j != -1) {
            ans.add(i);
            ans.add(j);
        }
        return ans;
    }

    boolean hasPattern(String s, String pattern) {
        if (s.length() < pattern.length()) return false;
        if (s.length() == pattern.length()) return s.equals(pattern);
        int pLen = pattern.length();
        int pHash = 0, sHash = 0;
        char[] pChars = pattern.toCharArray(), sChars = s.toCharArray();
        for (int i = 0; i < pLen; i++)
            pHash += hash(pChars[i], pLen - i - 1);
        for (int i = 0; i < pLen; i++)
            sHash += hash(sChars[i], pLen - i - 1);
        if (sHash == pHash) return true;
        for (int i = pLen; i < sChars.length; i++) {
            sHash = (sHash - hash(sChars[i - pLen], pLen - 1)) * 10;
            sHash += hash(sChars[i], 0);
            if (sHash == pHash) return true;
        }
        return false;
    }

    ArrayList<Integer> findPatternIndex(String s, String pattern) {
        if (s.length() < pattern.length()) return getListFromIndexes(-1, -1);
        if (s.length() == pattern.length()) {
            if (s.equals(pattern)) return getListFromIndexes(0, pattern.length() - 1);
            else getListFromIndexes(-1, -1);
        }
        int pLen = pattern.length();
        int pHash = 0, sHash = 0;
        char[] pChars = pattern.toCharArray(), sChars = s.toCharArray();
        for (int i = 0; i < pLen; i++)
            pHash += hash(pChars[i], pLen - i - 1);
        for (int i = 0; i < pLen; i++)
            sHash += hash(sChars[i], pLen - i - 1);
        if (sHash == pHash) return getListFromIndexes(0, pLen - 1);
        for (int i = pLen; i < sChars.length; i++) {
            sHash = (sHash - hash(sChars[i - pLen], pLen - 1)) * 10;
            sHash += hash(sChars[i], 0);
            if (sHash == pHash) return getListFromIndexes(i-pLen+1, i);
        }
        return getListFromIndexes(-1, -1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String pattern = sc.nextLine();
        RabinKarp ob = new RabinKarp();
        System.out.println(ob.hasPattern(s, pattern));
        System.out.println(ob.findPatternIndex(s, pattern).toString());
    }
}
