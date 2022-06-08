package leetcode.heap;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/sort-characters-by-frequency/">Problem</a>
 */
public class SortCharactersByFrequency {

    private static class Char {
        char ch;
        int freq;

        Char(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String frequencySort(String s) {
        var freq = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) freq.merge(c, 1, Integer::sum);
        var pq = new PriorityQueue<>((Char c1, Char c2) -> Integer.compare(c2.freq, c1.freq));
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(new Char(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            var ch = pq.poll();
            var st = (ch.ch+"").repeat(ch.freq);
            sb.append(st);
        }

        return sb.toString();
    }
}
