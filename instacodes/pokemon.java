package instacodes;

import java.util.Scanner;

public class pokemon {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int a1 = sc.nextInt(), h1 = sc.nextInt();
		String s1 = sc.next();
		int a2 = sc.nextInt(), h2 = sc.nextInt(), m, n;
		if ((s.equals("Fire") && s1.equals("Grass")) || (s.equals("Grass") && s1.equals("Water"))
				|| (s.equals("Water") && s1.equals("Fire"))) {
			a1 *= 2;
			a2 /= 2;
		} else {
			a1 /= 2;
			a2 *= 2;
		}
		m = (h2 % a1 == 0) ? h2 / a1 : h2 / a1 + 1;
		n = (h1 % a2 == 0) ? h1 / a2 : h1 / a2 + 1;
		if (m <= n)
			System.out.println("Trainer 1 wins");
		else
			System.out.println("Trainer 2 wins");
	}
}
