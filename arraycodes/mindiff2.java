package arraycodes;

import java.util.Arrays;
import java.util.Scanner;

public class mindiff2 {
	void find(int a[], int b[], int sum, int c[]) {
		int l = 0, r = b.length - 1;
		int diff = Integer.MAX_VALUE;
		while (l < a.length && r >= 0) {
			if (Math.abs(a[l] + b[r] - sum) < diff) {
				diff = Math.abs(a[l] + b[r] - sum);
				c[0] = a[l];
				c[1] = b[r];
			} else if (a[l] + b[r] < sum)
				l++;
			else
				r--;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		mindiff2 ob = new mindiff2();
		System.out.println("Enter no.of elements of 1st array");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter elements");
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		System.out.println("Enter no.of elements of 2nd array");
		int m = sc.nextInt();
		int b[] = new int[m];
		System.out.println("Enter elements");
		for (int i = 0; i < m; i++)
			b[i] = sc.nextInt();
		System.out.println("Enter value of sum");
		int x = sc.nextInt();
		int c[] = new int[2];
		System.out.println(" array 1 : " + Arrays.toString(a));
		System.out.println(" array 2 : " + Arrays.toString(b));
		ob.find(a, b, x, c);
		System.out.println("Pair with min difference = " + c[0] + "," + c[1]);
	}
}
