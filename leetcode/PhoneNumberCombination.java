package leetcode;

import java.util.*;

public class PhoneNumberCombination {
    HashMap<Character, List<Character>> map = new HashMap<>();

    PhoneNumberCombination() {
        map.put('1', new ArrayList<>());
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        var ans = new ArrayList<String>();
        if(digits.isEmpty()) return ans;
        find(digits, new StringBuilder(), ans);
        return ans;
    }

    public void find(String s, StringBuilder sb, ArrayList<String> ar) {
        if (s.length() == 0) {
            ar.add(sb.toString());
            return;
        }
        for (char c : map.get(s.charAt(0))) {
            sb.append(c);
            find(s.substring(1), sb, ar);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter digits");
        String s = sc.nextLine();
        PhoneNumberCombination ob = new PhoneNumberCombination();
        System.out.println(ob.letterCombinations(s));
    }
}
