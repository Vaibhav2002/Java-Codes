package data_structures.stack;

import java.util.*;

public class stack2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int c = 0;
			boolean flag = true;
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				if (x == 1)
					c++;
				else
					c--;
				if (c < 0)
					flag = false;
			}
			if (flag)
				System.out.println("Valid");
			else
				System.out.println("Invalid");
		}
	}
}
