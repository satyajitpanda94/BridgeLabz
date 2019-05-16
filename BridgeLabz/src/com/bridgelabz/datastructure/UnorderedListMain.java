package com.bridgelabz.datastructure;
/*
* created by: Satyajit Panda
* Date - 01/05/2019
*
* Purpose: Read the Text from a file, split it into words and arrange it as Linked List.
Take a user input to search a Word in the List. If the Word is not found then add it
to the list, and if it found then remove the word from the List. In the end save the
list into a file.
**/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnorderedListMain {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(
				"/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/datastructure/UnorderedLinkListInputFile"));
		String s = sc.nextLine() + ',';

		UnorderedList<String> ull = new UnorderedList<>();
		int start = 0;
		int end = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ',') {
				start = end + 1;
				end = i;
				ull.add(s.substring(start, end));
			}
		}
		ull.printList();
		System.out.println("Enter a word :");
		Scanner sca = new Scanner(System.in);
		String text = sca.nextLine();
		if (ull.checkTheWord(text))
			ull.remove(text);
		else
			ull.add(text);
		ull.printList();
		ull.addlistToFile();
		sc.close();
		sca.close();
	}
}
