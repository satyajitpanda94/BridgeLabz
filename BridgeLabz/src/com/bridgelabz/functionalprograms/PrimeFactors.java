package com.bridgelabz.functionalprograms;

/*
* created by: Satyajit Panda
* Date 11/04/2019
*
* Purpose: Print the prime factors of number N.
**/
import java.util.Scanner;
import java.util.InputMismatchException;


public class PrimeFactors {
	public static void main(String[] args) {
		System.out.println("Enter Number :");
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			try {
				n = sc.nextInt();
				int i = 2;
				int max = (int) Math.sqrt(n);
				System.out.println("Prime factors are :");
				while (i <= max) {
					if (n % i == 0) {
						System.out.print(i + " ");
						n = n / i;
					} else if (n <= 1)
						break;
					else
						i++;
				}
				if (n > 1)
					System.out.print(n);

				sc.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("invalid Enter,Enter Integer type data :");
//				clears buffer
				sc.next();
			}
		}

	}
}
