package arraycodes;

import java.util.Scanner;

public class palindromic_path {
	Scanner sc = new Scanner(System.in);

	void input(int a[][]) {
		System.out.println("Enter elements");
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a[0].length; j++)
				a[i][j] = sc.nextInt();
	}

	void display(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String args[]) {
		palindromic_path ob = new palindromic_path();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no.of rows and columns");
		int a[][] = new int[sc.nextInt()][sc.nextInt()];
		ob.input(a);
		System.out.println("\nOriginal matrix");
		ob.display(a);
		int count = 0;
		for (int i = 1; i < a.length - 1; i++) {
			for (int j = 1; j < a[0].length; j++)
				if ((a[i - 1][j] == a[i + 1][j]) && (a[i][j + 1] == a[i][j - 1]))
					count++;
		}
		System.out.println("\nNo.of palindromic paths = " + count);
	}
}
