package data_structures.stack;

import java.util.*;

public class stack {
	public static void main(String args[])
	{
		Stack<String> ob = new Stack<String>();
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		String x;
		while(t-->0)
		{
			int n=sc.nextInt();
			try
			{
				for(int i=0;i<n;i++)
				{
					if(sc.nextInt()==1)
						ob.push("a");
					else if(sc.nextInt()==0)
					    x=ob.pop();
				}
			}
			catch(Exception e)
			{
				System.out.println("Invalid");
				System.exit(0);
			}
			System.out.println("valid");
		}
		
		
	}

}
