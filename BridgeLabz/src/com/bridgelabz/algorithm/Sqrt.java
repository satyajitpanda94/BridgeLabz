package com.bridgelabz.algorithm;
/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: Write a static function sqrt to compute the square root of a nonnegative number c
given in the input using Newton's method.
**/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sqrt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Enter number : ");
				double num = sc.nextDouble();
				while (num < 0) {
					System.out.println("Number can't be negative, so Re-enter :");
					num = sc.nextDouble();
				}
				System.out.println("Square root of the number is : " + Util.sqrt(num));
				sc.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid Enter,Enter Double type data :");
//		clears buffer
				sc.next();
			}
		}
	}
}