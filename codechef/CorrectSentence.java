package codechef;

import java.util.HashSet;
import java.util.Scanner;

public class CorrectSentence {

    HashSet<Character> firstLanguage = new HashSet<>(), secondLanguage = new HashSet<>();

    CorrectSentence() {
        for (char i = 'a'; i <= 'm'; i++)
            firstLanguage.add(i);
        for (char i = 'N'; i <= 'Z'; i++)
            secondLanguage.add(i);
    }

    public boolean isCorrect(String s) {
        char[] c = s.toCharArray();
        if (c.length == 1)
            return (firstLanguage.contains(c[0]) || secondLanguage.contains(c[0]));
        if (!firstLanguage.contains(c[0]) && !secondLanguage.contains(c[0]))
            return false;
        boolean isFromFirstLanguage = firstLanguage.contains(c[0]);
        for (int i = 1; i < c.length; i++) {
            if (!firstLanguage.contains(c[i]) && !secondLanguage.contains(c[i]))
                return false;
            if (isFromFirstLanguage && !firstLanguage.contains(c[i]))
                return false;
            else if (!isFromFirstLanguage && !secondLanguage.contains(c[i]))
                return false;
        }
        return true;
    }

    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        CorrectSentence ob = new CorrectSentence();
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            boolean isCorrect = true;
            for (int i = 0; i < k; i++) {
                String s = sc.next();
                if (!ob.isCorrect(s)) {
                    isCorrect = false;
                    break;
                }
            }
            System.out.println(isCorrect ? "YES" : "NO");
        }
    }
}
