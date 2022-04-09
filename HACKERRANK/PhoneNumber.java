package HACKERRANK;

import java.util.HashMap;

public class PhoneNumber {

    private static HashMap<String, Character> map;

    PhoneNumber() {
        map = new HashMap<>();
        map.put("zero", '0');
        map.put("one", '1');
        map.put("two", '2');
        map.put("three", '3');
        map.put("four", '4');
        map.put("five", '5');
        map.put("six", '6');
        map.put("seven", '7');
        map.put("eight", '8');
        map.put("nine", '9');
    }

    public String getPhoneNumber(String s) {
        var words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("double")) {
                sb.append(getDigits(map.get(words[i + 1]), 2));
                i++;
            } else if (words[i].equals("triple")) {
                sb.append(getDigits(map.get(words[i + 1]), 3));
                i++;
            } else sb.append(map.get(words[i]));
        }
        return sb.toString();
    }

    private String getDigits(Character digit, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(digit).repeat(Math.max(0, count)));
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}
