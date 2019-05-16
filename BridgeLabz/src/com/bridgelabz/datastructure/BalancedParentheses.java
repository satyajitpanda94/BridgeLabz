package com.bridgelabz.datastructure;

/*
* created by: Satyajit Panda
* Date 03/05/2019
*
* Purpose: Take an Arithmetic Expression such as
(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) where parentheses are used to order the
performance of operations. Ensure parentheses must appear in a balanced
fashion.
**/
import java.util.Scanner;

public class BalancedParentheses {
	public static void main(String[] args) {
		System.out.print("Enter Parentheses : ");
		Scanner scanner = new Scanner(System.in);
		String parentheses = scanner.nextLine();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < parentheses.length(); i++) {
			if (parentheses.charAt(i) == '(' || parentheses.charAt(i) == '{' || parentheses.charAt(i) == '[')
				stack.push(parentheses.charAt(i));
			else if (parentheses.charAt(i) == ')' || parentheses.charAt(i) == '}' || parentheses.charAt(i) == ']')
				stack.pop();
			else
				continue;
		}
		if (stack.isEmpty())
			System.out.println("True - Arithmetic Expression is balanced.");
		else
			System.out.println("False - Arithmetic Expression is not balanced.");
		scanner.close();
	}
}
