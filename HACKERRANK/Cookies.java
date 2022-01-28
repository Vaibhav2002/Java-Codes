package HACKERRANK;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Cookies {
    static int cookies(int k, int[] A) {
        int count = 0;
        PriorityQueue<Integer> ob = new PriorityQueue<>();
        for(int i:A)
            ob.add(i);
        while (ob.size() != 1) {
            if(ob.peek()>=k)
                break;
            int a = ob.poll(), b = ob.poll();
            int val = a + 2 * b;
            ob.add(val);
            count++;
        }
        return (ob.peek() >= k)?count:-1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        System.out.println(result);
    }
}
