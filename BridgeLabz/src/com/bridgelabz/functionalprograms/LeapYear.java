package com.bridgelabz.functionalprograms;

/*
* created by: Satyajit Panda
* Date 10/04/2019
*
* Purpose: Print the year is a Leap Year or not and ensure year is a 4 digit number..
**/
import java.util.Scanner;
import java.util.InputMismatchException;


public class LeapYear {
	public static void main(String[] args) {
		System.out.println("Enter four digit year to check leap year :");
		Scanner sc = new Scanner(System.in);
		int year;

//		Handles InputMismatchException
		while (true) {
			try {
				year = sc.nextInt();

//				If user enters year apart from four digit, while loop handles that
				while (year < 1000 || year > 9999) {
					System.out.println("Year should be four digit number, Re-enter year :");
					year = sc.nextInt();
				}
				if (year % 400 == 0)
					System.out.println("Year is a Leap year.");
				else if (year % 100 == 0)
					System.out.println("Year is not a Leap year.");
				else if (year % 4 == 0)
					System.out.println("Year is a Leap year.");
				else
					System.out.println("Year is not a Leap year.");
				System.out.println("\nDo you want to continue and enter new value, than enter yes or no.");
				String yes = sc.next();

				while (yes.equals("yes")) {
					main(args);
				}
				sc.close();
				break;

			} catch (InputMismatchException e) {
				System.out.println("Invalid Datatype, so Re-enter:");
//				clears buffer
				sc.next();
			}

		}

	}
}
