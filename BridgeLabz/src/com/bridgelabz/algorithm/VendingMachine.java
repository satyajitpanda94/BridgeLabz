package com.bridgelabz.algorithm;
/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: There is 1, 2, 5, 10, 50, 100, 500 and 1000 Rs Notes which can be
returned by Vending Machine. Write a Program to calculate the minimum number
of Notes as well as the Notes to be returned by the Vending Machine as a
Change.
**/
import java.util.InputMismatchException;
import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {

		int a[] = { 1, 2, 5, 10, 50, 100, 500, 1000 };
		int l = a.length - 1;
		Scanner s = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Enter Rupee :");
				int m = s.nextInt();
				int z = Util.vandingMachine(m, l, a);
				;
				System.out.println("Minimum no of notes : " + z);
				s.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid Enter,Enter Integer type data :");
//				clears buffer
				s.next();
			}
		}
	}
}