package leetcode.heap;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-words/">Problem</a>
 **/
public class TopKFrequentWords {

    private static class Word implements Comparable<Word> {
        String word;
        int freq;

        public Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compareTo(Word o) {
            return (freq != o.freq) ? Integer.compare(o.freq, freq) : word.compareTo(o.word);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        for(String word:words) freqMap.merge(word, 1, Integer::sum);
        PriorityQueue<Word> q = new PriorityQueue<>();
        for(String word:freqMap.keySet()){
            q.add(new Word(word, freqMap.get(word)));
        }
        List<String> ans = new ArrayList<>();
        while(!q.isEmpty() && k-->0) ans.add(q.poll().word);
        return ans;
    }
}
