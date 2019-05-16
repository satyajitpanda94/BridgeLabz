package com.bridgelabz.datastructure;
/*
* created by: Satyajit Panda
* Date 03/05/2019
*
* Purpose: A palindrome is a string that reads the same forward and backward, for
example, radar, toot, and madam. We would like to construct an algorithm to
input a string of characters and check whether it is a palindrome.
**/

import java.util.Scanner;

public class PalindromeChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter word :");
		String word = sc.nextLine();
		Deque<Character> deque = new Deque<>();
		for (int i = 0; i < word.length(); i++)
			deque.addRear(word.charAt(i));
		char frontValue = '\0', rearValue = '\0';

		while (deque.size() > 1) {
			frontValue = deque.removeFront();
			rearValue = deque.removeRear();
			if (frontValue != rearValue)
				break;
		}

		if (frontValue == rearValue)
			System.out.println("Word is Palindrome.");
		else
			System.out.println("Word is not Palindrome.");
		sc.close();
	}
}
