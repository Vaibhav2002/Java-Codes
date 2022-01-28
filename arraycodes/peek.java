package arraycodes;

import java.util.Arrays;
import java.util.Scanner;

public class peek {
		int peakfind(int a[],int l,int r)
		{
			int mid=(l+r)/2;
			if(mid==0||mid==a.length-1||(a[mid]>=a[mid-1]&&a[mid]>=a[mid+1]))
				return mid;
			if(a[mid-1]>a[mid])
				return peakfind(a,l,mid-1);
			else
				return peakfind(a,mid+1,r);
		}
		public static void main(String args[])
		{
			peek ob=new peek();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter size of array");
			int a[]=new int[sc.nextInt()];
			System.out.println("Enter elements of array");
			for(int i=0;i<a.length;i++)
				a[i]=sc.nextInt();
			System.out.println("Array is : "+Arrays.toString(a));
			System.out.println("\nPeak element : "+a[ob.peakfind(a,0,a.length-1)]);
	}
}
