package college;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        char c[] = s.toCharArray();
        for (char ch : c) map.merge(ch, 1, Integer::sum);
        for (char ch : c) {
            if (map.get(ch) == 1) {
                System.out.println(ch);
                break;
            }
        }
    }
}
