package codechef;

import java.util.ArrayList;
import java.util.Scanner;

public class SleepCycle {
    public static void main(String arge[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long l = sc.nextLong(), h = sc.nextLong();
            String s = sc.next();
            ArrayList<Integer> ar= new ArrayList<>();
            int count = 0;
            boolean completed = false;
            for (char c : s.toCharArray()) {
                if (c == '0') count++;
                else ar.add(count);
                if (count == h) {
                    completed = true;
                    break;
                }
            }
            if(completed)
            System.out.println("YES");
        }
    }
}
