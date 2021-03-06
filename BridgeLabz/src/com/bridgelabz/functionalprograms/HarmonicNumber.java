package com.bridgelabz.functionalprograms;

/*
* created by: Satyajit Panda
* Date 11/04/2019
*
* Purpose: Print the Nth Harmonic Value.
**/
import java.util.Scanner;
import java.util.InputMismatchException;

public class HarmonicNumber {
	public static void main(String[] args) {
		System.out.println("Enter harmonic Value N :");
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			try {
				n = sc.nextInt();
				while (n < 1) {
					System.out.println("N can't be Zero or lesser, So re-enter.");
					n = sc.nextInt();
				}
				harmonicValue(n);
				sc.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("invalid Enter,Enter Integer type data :");
//				clears buffer
				sc.next();
			}
		}

	}

	public static void harmonicValue(int n) {
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + (1.0 / i);
		}
		System.out.println("Harmonic Value is : " + sum);

	}
}
