package testing;

import java.util.Scanner;

class Helper {
    private int x;

    Helper() {
        x = 5;
        float y = 4f;
    }

    protected static Helper create() {
        return new Helper();
    }
}

public class Testing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number");
        int n = sc.nextInt();
        System.out.println((n % 2 == 0) ? "Even" : "Odd");
    }
}
