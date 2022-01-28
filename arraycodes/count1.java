package arraycodes;

import java.util.Arrays;
import java.util.Scanner;

public class count1 {
	int find(int a[], int l, int u) {
		if (u >= l) {
			int mid = (l + u) / 2;
			if ((mid == u || a[mid + 1] == 0) && (a[mid] == 1))
				return mid + 1;
			if (a[mid] == 1)
				return find(a, mid + 1, u);
			else
				return find(a, l, mid - 1);
		}
		return 0;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		count1 ob = new count1();
		System.out.println("Enter no.of elements");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter elements");
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		System.out.println("Original array : " + Arrays.toString(a));
		System.out.println("freq of 1 : " + ob.find(a, 0, a.length - 1));
	}
}
