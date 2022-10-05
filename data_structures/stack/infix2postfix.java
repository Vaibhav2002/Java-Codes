package data_structures.stack;

import java.util.*;

public class infix2postfix {
	boolean check(char c, char ch) {
		char cha = '^';
		String s1 = "*%/", s2 = "+-";
		if (c == ch)
			return true;
		else {
			boolean b = s1.indexOf(ch) != -1 || s2.indexOf(ch) != -1;
			if ((c == cha && b))
				return true;
			else if (s1.indexOf(c) != -1 && b)
				return true;
			else return s2.indexOf(c) != -1 && s2.indexOf(ch) != -1;
		}
	}

	public static void main(String args[]) {
		infix2postfix ob2 = new infix2postfix();
		Scanner sc = new Scanner(System.in);
		Stack<Character> ob = new Stack<Character>();
		System.out.println("Enter the infix expression");
		String s = sc.next().toUpperCase();
		StringBuilder s1 = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!Character.isLetter(ch)) {
				if (ob.isEmpty())
					ob.push(ch);
				else if (ch == ')') {
					while (ob.peek() != '(')
						s1.append(ob.pop());
					ob.pop();
				} else if (ob2.check(ob.peek(), ch)) {
					while (ch != '(' &&!ob.isEmpty()&& ob2.check(ob.peek(), ch))
						s1.append(ob.pop());
					ob.push(ch);
				} else if (!ob.isEmpty())
					ob.push(ch);
			} else
				s1.append(ch);
		}
		while (!ob.isEmpty())
			s1.append(ob.pop());
		System.out.println("Postfix expression:");
		System.out.println(s1);
	}
}
