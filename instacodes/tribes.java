package instacodes;

import java.util.*;

public class tribes {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String s = sc.nextLine();
			int a = 0, b = 0;
			int c = 0, x = -1;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'A') {
					if (c == 0) {
						a++;
						c = 1;
						x = i;
					} else if (c == 1) {
						a += i - x;
						c=1;
					} else
						c = 1;
						x=i;
						a++;
				} else if (s.charAt(i) == 'B') {
					if (c == 0) {
						b++;
						c = 2;
						x = i;
					} else if (c == 2) {
						b += i - x;
						c=2;
						x=i;
					} else
						c = 2;
						x=i;
						b++;
				}
			}
			System.out.println(a+" "+b);

		}

	}
}
