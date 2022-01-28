package arraycodes;

import java.util.Arrays;
import java.util.Scanner;


public class mindiff {
	void find(int a[],int b[],int sum)
	{
		int l=0,r=a.length-1;
		int diff=Integer.MAX_VALUE;
		while(l<r)
		{
			if(Math.abs(a[l]+a[r]-sum)<diff)
			{
				diff=Math.abs(a[l]+a[r]-sum);
				b[0]=a[l];
				b[1]=a[r];
			}
			else if(a[l]+a[r]<sum)
				l++;
			else
				r--;
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		mindiff ob=new mindiff();
		System.out.println("Enter no.of elements");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter elements");
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		System.out.println("Enter value of sum");
		int x = sc.nextInt();
		int b[]=new int[2];
		System.out.println("Original array : " + Arrays.toString(a));
		ob.find(a, b, x);
		System.out.println("Pair with min difference = "+b[0]+","+b[1]);
	}
}
