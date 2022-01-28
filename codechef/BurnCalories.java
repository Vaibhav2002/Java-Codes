package codechef;

import java.util.HashMap;
import java.util.Scanner;

public class BurnCalories {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long total_calorie = 0;
        HashMap<Character, Integer> calorie = new HashMap<>();
        calorie.put('D', 238);
        calorie.put('T', 244);
        calorie.put('M', 138);
        calorie.put('B', 279);
        calorie.put('C', 186);
        for (char c : s.toCharArray())
            total_calorie += calorie.get(c);
        long running=total_calorie/50;
        total_calorie%=50;
        long cycling = total_calorie/5;
        total_calorie%=5;
        long walking=total_calorie/=0.5;
        total_calorie/=0.5;
        System.out.println(running+"\n"+cycling+"\n"+walking);
    }
}
