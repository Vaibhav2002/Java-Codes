package algorithms.soting;

import java.util.*;

public class mergesort {
	void accept(int a[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter elements");
		for (int i = 0; i < a.length; i++)
			a[i] = sc.nextInt();
	}

	void divide(int a[]) {
		if (a.length == 1)
			return;
		int left[] = Arrays.copyOfRange(a, 0, a.length / 2);
		int right[] = Arrays.copyOfRange(a, a.length / 2, a.length);
		divide(left);
		divide(right);
		merge(a, left, right);
	}

	void merge(int c[],int a[],int b[])
	{
		int i=0,j=0,k=0;
		while(i<a.length&&j<b.length)
		{
			if(a[i]<b[j])
				c[k++]=a[i++];
			else
				c[k++]=b[j++];
		}
		while(i<a.length)
			c[k++]=a[i++];
		while(j<b.length)
			c[k++]=b[j++];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size ");
		int a[] = new int[sc.nextInt()];
		mergesort ob = new mergesort();
		ob.accept(a);
		System.out.println("Original array : " + Arrays.toString(a));
		ob.divide(a);
		System.out.println("Sorted array : " + Arrays.toString(a));
	}
}
