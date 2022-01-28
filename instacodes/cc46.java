package instacodes;

import java.util.Scanner;

public class cc46 {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		int a=sc.nextInt();
		int d=sc.nextInt();
		x=(a==0)?x-d:(a==180)?x+d:x;
		y=(a==270)?y-d:(a==90)?y+d:y;
		System.out.println("("+x+","+y+")");
	}
}
