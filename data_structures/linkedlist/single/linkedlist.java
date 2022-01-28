package data_structures.linkedlist.single;

import java.util.LinkedList;
import java.util.Scanner;

public class linkedlist {
	public static void main(String args[]) {
		LinkedList<String> ob = new LinkedList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to push\n2 to pop\n3 to display\nAny no. to exit to exit");
		while (true) {
			int c = sc.nextInt();
			switch (c) {
			case 2:
				try {
				System.out.println(ob.pop());
				}
				catch(Exception e)
				{
				System.out.println("Array underflow");
				}
				break;
			case 1:
				System.out.println("Enter name to push");
				ob.push(sc.next());
				break;
			case 3:
				System.out.println(ob.toString());
				break;
			default:
				System.exit(0);
			}
		}
	}
}
