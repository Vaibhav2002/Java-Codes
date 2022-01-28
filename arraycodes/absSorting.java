package arraycodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class absSorting {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=sc.nextInt();
		ArrayList <Integer> a=new ArrayList<Integer>(n);
		System.out.println("Enter elements");
		for(int i=0;i<n;i++)
			a.add(sc.nextInt());
		System.out.println("Original array \n"+a);
		Collections.sort(a, (i,j)->(Math.abs(j)<=Math.abs(i))?1:-1);
		System.out.println("Sorted array \n"+a);
		
	}
}
