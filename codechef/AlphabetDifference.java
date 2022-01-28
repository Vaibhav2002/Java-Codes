package codechef;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

// problem code ALPDIFF
public class AlphabetDifference {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String a = sc.nextLine(),b = sc.nextLine();
            HashSet<Character> aEle = new HashSet<>();
            for (char c : a.toCharArray()) aEle.add(c);
            TreeSet<Character> ans = new TreeSet<>();
            for (char c : b.toCharArray()) {
                if (!aEle.contains(c))
                    ans.add(c);
            }
            if (ans.isEmpty()) System.out.println("-1");
            else {
                StringBuilder finalAns = new StringBuilder();
                for (char c : ans) finalAns.append(c);
                System.out.println(finalAns);
            }
        }
    }
}
