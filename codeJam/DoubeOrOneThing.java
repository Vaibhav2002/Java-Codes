package codeJam;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class DoubeOrOneThing {
    private static Scanner sc = new Scanner(System.in);
    private static String ans = "";

//    private static void solve(int testCase) {
//        String s = sc.next();
//        char[] ch = s.toCharArray();
//        if(areAllLettersSame(s)){
//            System.out.println("Case #"+testCase+": "+s);
//            return;
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < ch.length; i++) {
//            if (i < ch.length - 1 && ch[i + 1] > ch[i])
//                sb.append(String.valueOf(ch[i]).repeat(2));
//            else sb.append(ch[i]);
//        }
//        System.out.println("Case #"+testCase+": "+ sb);
//    }

    private static void solve(int testCase) {
        ans = "";
        String s = sc.next();
        char[] ch = s.toCharArray();
        solveUsingDp(0, ch, "");
        System.out.println("Case #"+testCase+": "+ ans);
    }

    private static void solveUsingDp(int i, char[] og, String formed){
        if(i==og.length){
            if(ans.equals("")) ans =formed;
            else if(formed.compareTo(ans)<0) ans = formed;
            return;
        }
        StringBuilder sb = new StringBuilder(formed);
        sb.append(og[i]);
        StringBuilder sb2 = new StringBuilder(formed);
        sb2.append(String.valueOf(og[i]).repeat(2));
        solveUsingDp(i+1, og, sb.toString());
        solveUsingDp(i+1, og, sb2.toString());
    }

    private static boolean areAllLettersSame(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.merge(c, 1, Integer::sum);
        return map.size() == 1;
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++)
            solve(i);
    }
}
