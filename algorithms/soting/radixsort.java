package algorithms.soting;

import java.util.Arrays;
import java.util.Scanner;

public class radixsort {
	void sort(int a[],int n,int exp)
	{
		int count[]=new int[10];
		for(int i:a)
			count[(i/exp)%10]++;
		for(int i=1;i<count.length;i++)
			count[i]+=count[i-1];
		int output[]=new int[a.length];
		for(int i=a.length-1;i>=0;i--)
		{
			output[count[(a[i]/exp)%10]-1]=a[i];
			count[(a[i]/exp)%10]--;
		}
		for(int i=0;i<a.length;i++)
			a[i]=output[i];
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		radixsort ob=new radixsort();
		System.out.println("Enter no.of elements");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter elements");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		System.out.println("Original array : "+Arrays.toString(a));
		int max=Arrays.stream(a).max().getAsInt();
		for(int i=1;max/i>0;i*=10)
		ob.sort(a,n,i);
		System.out.println("Sorted array : "+Arrays.toString(a));
}
}
