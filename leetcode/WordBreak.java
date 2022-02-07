package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> dp = new HashMap<>();
        return find(s, new HashSet<>(wordDict), dp);
    }

    public boolean find(String s, Set<String> wordDict, HashMap<String, Boolean> dp) {
        if (s.isEmpty()) return true;
        if (dp.containsKey(s)) return dp.get(s);
        for (String word : wordDict) {
            int startIndex = s.indexOf(word);
            if (startIndex != -1) {
                StringBuilder sb = new StringBuilder();
                String left = s.substring(0, startIndex), right = s.substring(startIndex + word.length());
                boolean isPossible = find(left, wordDict, dp) & find(right, wordDict, dp);
                if (isPossible) {
                    dp.put(s, true);
                    return true;
                }
            }
        }
        dp.put(s, false);
        return false;
    }
}
