package stringcodes;

import java.util.HashMap;

public class Roman2Int {
    public int Roman_to_Int(String s) {
        HashMap<String, Integer> hash = new HashMap<>();
        hash.put("M", 1000);
        hash.put("CM", 900);
        hash.put("D", 500);
        hash.put("CD", 400);
        hash.put("C", 100);
        hash.put("XC", 90);
        hash.put("L", 50);
        hash.put("XL", 40);
        hash.put("X", 10);
        hash.put("IX", 9);
        hash.put("V", 5);
        hash.put("IV", 4);
        hash.put("I", 1);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1)
                sum += hash.get(s.charAt(i) + "");
            else {
                if (hash.containsKey(s.charAt(i) + "" + s.charAt(i + 1))) {
                    sum += hash.get(s.charAt(i) + "" + s.charAt(i + 1));
                    i++;
                } else
                    sum += hash.get(s.charAt(i) + "");
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Roman2Int().Roman_to_Int("XXIII"));
    }
}
