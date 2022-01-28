package arraycodes;

import java.util.Arrays;
import java.util.Scanner;

public class freq {
	int find_first(int a[], int x, int l, int u) {
		if (l > u)
			return -1;
		else {
			int mid = (l + u) / 2;
			if ((mid == 0 && a[mid] == x) || (a[mid] == x && a[mid - 1] < x))
				return mid;
			else if (a[mid] >= x)
				return find_first(a, x, l, mid - 1);
			else
				return find_first(a, x, mid + 1, u);
		}

	}

	int find_last(int a[], int x, int l, int u) {
		if (l > u)
			return -1;
		else {
			int mid = (l + u) / 2;
			if ((mid == a.length - 1 && a[mid] == x) || (a[mid] == x && a[mid + 1] > x))
				return mid;
			else if (a[mid] > x)
				return find_last(a, x, l, mid - 1);
			else
				return find_last(a, x, mid + 1, u);
		}
	}

	public static void main(String rgs[]) {
		Scanner sc = new Scanner(System.in);
		freq ob = new freq();
		System.out.println("Enter no.of elements");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter elements");
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		System.out.println("Enter element to find");
		int x = sc.nextInt();
		System.out.println("Original array : " + Arrays.toString(a));
		int r = ob.find_first(a, x, 0, a.length - 1);
		if (r == -1)
			System.out.println("Frequency = " + -1);
		else {
			int c = ob.find_last(a, x, 0, a.length - 1);
			System.out.println("Freq = " + (c - r + 1));
		}
	}
}
