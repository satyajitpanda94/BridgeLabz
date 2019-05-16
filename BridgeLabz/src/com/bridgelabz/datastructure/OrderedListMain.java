package com.bridgelabz.datastructure;

/*
* created by: Satyajit Panda
* Date 01/05/2019
*
* Purpose: Read a List of Numbers from a file and arrange it ascending Order in a
Linked List. Take user input for a number, if found then pop the number out of the
list else insert the number in appropriate position.
**/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderedListMain {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(
				"/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/datastructure/OrderedLinkedListTextInputFile"));
		String s = sc.nextLine() + ",";
		OrderedList<Integer> oll = new OrderedList<>();
		int start = 0, end = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ',') {
				start = end + 1;
				end = i;
				oll.add(Integer.parseInt(s.substring(start, end)));
			}
		}
		oll.printList();
		Scanner sca = new Scanner(System.in);
		System.out.println("Enter Number :");
		int num;
		while (true) {
			try {
				num = sca.nextInt();
				if (oll.checkNumber(num))
					oll.remove(num);
				else
					oll.add(num);
				oll.printList();
				oll.addlistToFile();
				sc.close();
				sca.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("You Entered Different Input Type, so Re-enter.");
				sca.nextLine();
			}
		}

	}
}
