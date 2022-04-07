package dsaSprint;

import java.util.HashMap;

public class KLengthSubstringWithDistinct {
    static int countOfSubstrings(String S, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char ch[] = S.toCharArray();
        for (int i = 0; i < k; i++) map.merge(ch[i], 1, Integer::sum);
        int count = 0;
        if (map.size() == k - 1) count++;
        for (int i = k; i < ch.length; i++) {
            int freq = map.get(ch[i-k]);
            if(freq == 1)
                map.remove(ch[i-k]);
            else map.put(ch[i-k], freq-1);
            map.merge(ch[i], 1, Integer::sum);
            if(map.size() == k-1) count++;
        }
        return count;
    }
}
