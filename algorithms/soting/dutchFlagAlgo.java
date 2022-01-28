package algorithms.soting;

import java.util.Arrays;
import java.util.Scanner;

public class dutchFlagAlgo {
	void sort(int a[]) {
		int l = 0, mid = 0, high = a.length - 1;
		while (mid <= high) {
			if (a[mid] == 0) {
				int temp = a[mid];
				a[mid] = a[l];
				a[l] = temp;
				l++;
				mid++;
			} else if (a[mid] == 1)
				mid++;
			else {
				int temp = a[mid];
				a[mid] = a[high];
				a[high] = temp;
				high--;
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		dutchFlagAlgo ob = new dutchFlagAlgo();
		System.out.println("Enter no.of elements");
		int a[] = new int[sc.nextInt()];
		System.out.println("Enter elements");
		for (int i = 0; i < a.length; i++)
			a[i] = sc.nextInt();
		System.out.println("\nOriginal array : " + Arrays.toString(a));
		ob.sort(a);
		System.out.println("\nSorted array : " + Arrays.toString(a));
	}
}
