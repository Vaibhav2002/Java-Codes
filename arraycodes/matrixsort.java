package arraycodes;

import java.util.*;

public class matrixsort {
	Scanner sc= new Scanner(System.in);

	void accept(int a[][]) {
		System.out.println("Enter elements");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				a[i][j] = sc.nextInt();
		}
	}

	void reverse(int a[]) {
		for (int i = 0; i < a.length / 2; i++) {
			int temp = a[a.length - i - 1];
			a[a.length - i - 1] = a[i];
			a[i] = temp;
		}

	}

	void sort(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			int b[] = Arrays.copyOf(a[i], a[i].length);
			Arrays.parallelSort(b);
			if (i % 2 == 1)
				reverse(b);
			a[i] = Arrays.copyOf(b, b.length);
		}
	}

	void display(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		matrixsort ob = new matrixsort();
		System.out.println("Enter no.of rows and colums");
		int a[][] = new int[sc.nextInt()][sc.nextInt()];
		ob.accept(a);
		System.out.println("Original matrix\n");
		ob.display(a);
		ob.sort(a);
		System.out.println("\nSorted matrix\n");
		ob.display(a);
	}
}
