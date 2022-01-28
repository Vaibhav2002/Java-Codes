package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class Integer2Roman {

    public String intToRoman(int num) {
        HashMap<Integer, String> hash = new HashMap<>();
        hash.put(1000, "M");
        hash.put(900, "CM");
        hash.put(500, "D");
        hash.put(400, "CD");
        hash.put(100, "C");
        hash.put(90, "XC");
        hash.put(50, "L");
        hash.put(40, "XL");
        hash.put(10, "X");
        hash.put(9, "IX");
        hash.put(5, "V");
        hash.put(4, "IV");
        hash.put(1, "1");
        StringBuilder s = new StringBuilder();
        int[] a = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i : a) {
            if (num == 0)
                break;
            while (num >= i) {
                s.append(hash.get(i));
                num -= i;
            }
        }
        return s.toString();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer2Roman ob = new Integer2Roman();
        System.out.println(ob.intToRoman(n));
    }
}
