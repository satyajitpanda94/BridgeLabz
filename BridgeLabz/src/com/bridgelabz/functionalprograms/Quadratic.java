package com.bridgelabz.functionalprograms;
/*
* created by: Satyajit Panda
* Date 26/04/2019
*
* Purpose: Write a program Quadratic.java to find the roots of the equation a*x*x + b*x + c.
Since the equation is x*x, hence there are 2 roots.
**/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Quadratic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		while (true) {
			try {
				System.out.println("Enter a :");
				a = sc.nextInt();
				System.out.println("Enter b :");
				int b = sc.nextInt();
				System.out.println("Enter c :");
				int c = sc.nextInt();
				System.out.println("Your Quadratic Equation is : " + a + "x*x + " + b + "x + " + c);
				double delta = (b * b) - (4 * a * c);
				if (delta >= 0) {
					double root1 = (-b + Math.sqrt(delta)) / (2 * a);
					double root2 = (-b - Math.sqrt(delta)) / (2 * a);
					System.out.println("Two roots of equation are : " + root1 + ", " + root2);
				} else {
					String root1 = "(" + (-b) + "+sqrtOf(" + delta + "))/" + (2 * a);
					String root2 = "(" + (-b) + "-sqrtOf(" + delta + "))/" + (2 * a);
					System.out.println("Two roots of equation are : " + root1 + ", " + root2);
				}
				sc.close();

				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid Enter,Enter Integer type data :");
//			clears buffer
				sc.nextLine();
			}
		}

	}
}