package instacodes;

import java.util.Scanner;

public class niggano {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			String sq = Integer.toString(n * n);
			String sqr = Double.toString(Math.sqrt(n));
			System.out.println(sq + "\n" + sqr);
			boolean check = false;
			for (int i = 0; i < sq.length(); i++) {
				char ch = sq.charAt(i);
				if (sqr.indexOf(ch) != -1) {
					check = true;
					break;
				}
			}
			if (check)
				System.out.println("NIGGA NUMBER");
			else
				System.out.println("NOT NIGGA NUMBER");
		}
		sc.close();
	}

}
