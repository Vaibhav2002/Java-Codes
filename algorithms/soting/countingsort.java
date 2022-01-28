package algorithms.soting;

import java.util.Arrays;
import java.util.Scanner;

public class countingsort {
	void sort(int a[],int n)
	{
		int count[]=new int[n+1];
		for(int i:a)
			count[i]++;
		for(int i=1;i<count.length;i++)
			count[i]+=count[i-1];
		int output[]=new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			output[count[a[i]]-1]=a[i];
			count[a[i]]--;
		}
		for(int i=0;i<a.length;i++)
			a[i]=output[i];
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		countingsort ob=new countingsort();
		System.out.println("Enter no.of elements");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter elements");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		System.out.println("Original array : "+Arrays.toString(a));
		ob.sort(a, Arrays.stream(a).max().getAsInt());
		System.out.println("Sorted array : "+Arrays.toString(a));
	}
}
