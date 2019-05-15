package com.bridgelabz.functionalprograms;

/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: Flip Coin and print percentage of Heads and Tails
**/

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlipCoin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of times to Flip Coin :");
		int num;

//	    Handles  InputMismatchException and allows re-enter

		while (true) {
			try {
				num = sc.nextInt();
				
//				if number is -ve, while block runs to re-enter number
				while (num < 0) {
					System.out.println("Number can't be -ve, so re-enter.");
					num = sc.nextInt();
				}

				int noOfTails = 0;
				for (int index = 1; index <= num; index++) {
					double flipCoin = Math.random();
					if (flipCoin < 0.5)
						noOfTails++;
				}
				double percentageOfTails = (noOfTails * 100.0) / num;
				double percentageOfHeads = 100.0 - percentageOfTails;
				System.out.println(
						"Percentage of Heads : " + percentageOfHeads + "\nPercentage of Tails : " + percentageOfTails);
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
