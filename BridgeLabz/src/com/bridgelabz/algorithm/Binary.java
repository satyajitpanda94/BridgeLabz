package com.bridgelabz.algorithm;
/*
* created by: Satyajit Panda
* Date 30/04/2019
*
* Purpose: Write Binary.java to read an integer as an Input, convert to Binary using toBinary
function and perform the following functions.
i. Swap nibbles and find the new number.
ii. Find the resultant number is the number is a power of 2.
A nibble is a four­bit aggregation, or half an octet. There are two nibbles in a byte.
**/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Binary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Enter number :");
				int num = sc.nextInt();
				String binary = Util.toBinary(num);
				binary = Util.binaryPadding(binary);
				String binary1 = binary.substring(0, 8) + " " + binary.substring(8, 16) + " " + binary.substring(16, 24)
						+ " " + binary.substring(24);
				System.out.println(binary1);
				binary = Util.swapNibbles(binary);
				binary1 = binary.substring(0, 8) + " " + binary.substring(8, 16) + " " + binary.substring(16, 24) + " "
						+ binary.substring(24);
				System.out.println(binary1);
				Util.findDecimal(binary);
				sc.close();
				break;

			} catch (InputMismatchException e) {
				System.out.println("Invalid Datatype, Enter Integer Type Data,so Re-enter:");
//		clears buffer
				sc.next();
			}
		}
	}

}