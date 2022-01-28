package HACKERRANK;

import java.util.Scanner;
import java.util.Stack;

public class maxStack {


    public static void main(String[] args) {
        Stack<Integer> main = new Stack<>();
        Stack<Integer> max = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        max.push(Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    int y = sc.nextInt();
                    main.push(y);
                    int max1 = max.peek();
                    max.push(Math.max(y, max1));
                    break;
                case 2:
                    main.pop();
                    max.pop();
                    break;
                case 3:
                    System.out.println(max.peek());
                    break;
            }
        }
    }
}
