package data_structures.stack;

import java.util.*;

public class infix2prefix {
	String reverse(String s) {
		String s1 = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ')')
				ch = '(';
			else if (ch == '(')
				ch = ')';
			s1 = ch + s1;
		}
		return s1;
	}

	boolean check(char c, char ch) {
		char cha = '^';
		String s1 = "*%/", s2 = "+-";
		if (c == ch)
			return true;
		else if ((c == cha && (s1.indexOf(ch) != -1 || s2.indexOf(ch) != -1)))
			return true;
		else if (s1.indexOf(c) != -1 && (s1.indexOf(ch) != -1 || s2.indexOf(ch) != -1))
			return true;
		else if (s2.indexOf(c) != -1 && s2.indexOf(ch) != -1)
			return true;
		else
			return false;
	}

	public static void main(String args[]) {
		infix2prefix ob2 = new infix2prefix();
		Scanner sc = new Scanner(System.in);
		Stack<Character> ob = new Stack<Character>();
		System.out.println("Enter the infix expression");
		String s = sc.next().toUpperCase(), s1 = "";
		s = ob2.reverse(s);
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!Character.isLetter(ch)) {
				if (ob.isEmpty())
					ob.push(ch);
				else if (ch == ')') {
					while (ob.peek() != '(')
						s1 += ob.pop();
					ob.pop();
				} else if (ob2.check(ob.peek(), ch)) {
					while (ch != '(' && !ob.isEmpty() && ob2.check(ob.peek(), ch))
						s1 += ob.pop();
					ob.push(ch);
				} else if (!ob.isEmpty())
					ob.push(ch);
			} else
				s1 += ch;
		}
		while (!ob.isEmpty())
			s1 += ob.pop();
		s1 = ob2.reverse(s1);
		System.out.println("Prefix expression:");
		System.out.println(s1);
	}
}