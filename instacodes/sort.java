package instacodes;

import java.util.Arrays;
import java.util.Scanner;

class sort {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = sc.nextInt();
		System.out.println("Enter elements");
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		System.out.println("Enter number");
		int x = sc.nextInt();
		int b[] = Arrays.copyOf(a, n);
		Arrays.sort(b);
		int c = 0;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if ((a[i] != b[i]) && a[i] != x)
				c++;
			else if ((a[i] != b[i]) && a[i] == x)
				flag = true;
			if (c > 1)
				break;
		}
		if (c == 0 && flag == false)
			System.out.println("Already sorted");
		else if (c == 1 && flag) {
			System.out.print("Swapped ");
			for (int i : b)
				System.out.print(i + " ");
		} else
			System.out.println("Not swapped");
		sc.close();
	}
}