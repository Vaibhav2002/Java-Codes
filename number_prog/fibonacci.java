package number_prog;

import java.util.Scanner;

public class fibonacci {
	int a[] = new int[100];

	fibonacci() {
		for (int i = 0; i < 100; i++)
			a[i] = -1;
	}

	int fibo(int n) {
		if (a[n] != -1)
			return a[n];
		else {
			if (n <= 1)
				a[n] = n;
			else
				a[n] = fibo(n - 1) + fibo(n - 2);
			return a[n];
		}
	}

	public static void main(String args[]) {
		fibonacci ob = new fibonacci();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
			System.out.print(ob.fibo(i) + " ");
		sc.close();
	}
}
